package com.mcode.alumninetwork3i.service.notificationService;

import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.NotificationEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.repository.NotificationRepository;
import com.mcode.alumninetwork3i.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserService userService;

    @Override
    public NotificationEntity getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId).orElseThrow(NotificationNotFoundException::new);
    }

    @Override
    public NotificationEntity getNotificationByReceiverAndOwningPostAndType(UserEntity receiver, Post owningPost, String type) {
        return notificationRepository.findByReceiverAndOwningPostAndType(receiver, owningPost, type)
                .orElseThrow(NotificationNotFoundException::new);
    }

    @Override
    public void sendNotification(UserEntity receiver, UserEntity sender, PostEntity owningPost, CommentEntity owningComment, String type) {
        try {
            NotificationEntity targetNotification = getNotificationByReceiverAndOwningPostAndType(receiver, owningPost, type);
            targetNotification.setSender(sender);
            targetNotification.setIsSeen(false);
            targetNotification.setIsRead(false);
            targetNotification.setDateUpdated(new Date());
            targetNotification.setDateLastModified(new Date());
            notificationRepository.save(targetNotification);
        } catch (NotificationNotFoundException e) {
            NotificationEntity newNotification = new NotificationEntity();
            newNotification.setType(type);
            newNotification.setReceiver(receiver);
            newNotification.setSender(sender);
            newNotification.setOwningPost(owningPost);
            newNotification.setOwningComment(owningComment);
            newNotification.setIsSeen(false);
            newNotification.setIsRead(false);
            newNotification.setDateCreated(new Date());
            newNotification.setDateUpdated(new Date());
            newNotification.setDateLastModified(new Date());
            notificationRepository.save(newNotification);
        }
    }

    @Override
    public void removeNotification(UserEntity receiver, PostEntity owningPost, String type) {
        UserEntity authUser = userService.getAuthenticatedUser();
        NotificationEntity targetNotification = getNotificationByReceiverAndOwningPostAndType(receiver, owningPost, type);
        if (targetNotification.getSender() != null && targetNotification.getSender().equals(authUser)) {
            targetNotification.setSender(null);
            targetNotification.setDateLastModified(new Date());
            notificationRepository.save(targetNotification);
        }
    }

    @Override
    public List<NotificationEntity> getNotificationsForAuthUserPaginate(Integer page, Integer size) {
        UserEntity authUser = userService.getAuthenticatedUser();
        return notificationRepository.findNotificationsByReceiver(
                authUser,
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dateUpdated"))
        );
    }

    @Override
    public void markAllSeen() {
        UserEntity authUser = userService.getAuthenticatedUser();
        notificationRepository.findNotificationsByReceiverAndIsSeenIsFalse(authUser)
                .forEach(notification -> {
                    if (notification.getReceiver().equals(authUser)) {
                        notification.setIsSeen(true);
                        notification.setDateLastModified(new Date());
                        notificationRepository.save(notification);
                    }
                });
    }

    @Override
    public void markAllRead() {
        UserEntity authUser = userService.getAuthenticatedUser();
        notificationRepository.findNotificationsByReceiverAndIsReadIsFalse(authUser)
                .forEach(notification -> {
                    if (notification.getReceiver().equals(authUser)) {
                        notification.setIsSeen(true);
                        notification.setIsRead(true);
                        notification.setDateLastModified(new Date());
                        notificationRepository.save(notification);
                    }
                });
    }

    @Override
    public void deleteNotification(UserEntity receiver, PostEntity owningPost, String type) {
        NotificationEntity targetNotification = getNotificationByReceiverAndOwningPostAndType(receiver, owningPost, type);
        notificationRepository.deleteById(targetNotification.getId());
    }

    @Override
    public void deleteNotificationByOwningPost(PostEntity owningPost) {
        notificationRepository.deleteNotificationByOwningPost(owningPost);
    }

    @Override
    public void deleteNotificationByOwningComment(CommentEntity owningComment) {
        notificationRepository.deleteNotificationByOwningComment(owningComment);
    }
}
