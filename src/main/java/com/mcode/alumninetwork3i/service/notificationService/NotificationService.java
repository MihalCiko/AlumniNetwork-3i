package com.mcode.alumninetwork3i.service.notificationService;

import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.NotificationEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;

import java.util.List;

public interface NotificationService {
    NotificationEntity getNotificationById(Long notificationId);

    NotificationEntity getNotificationByReceiverAndOwningPostAndType(UserEntity receiver, PostEntity owningPost, String type);

    void sendNotification(UserEntity receiver, UserEntity sender, PostEntity owningPost, CommentEntity owningComment, String type);

    void removeNotification(UserEntity receiver, PostEntity owningPost, String type);

    List<NotificationEntity> getNotificationsForAuthUserPaginate(Integer page, Integer size);

    void markAllSeen();

    void markAllRead();

    void deleteNotification(UserEntity receiver, PostEntity owningPost, String type);

    void deleteNotificationByOwningPost(PostEntity owningPost);

    void deleteNotificationByOwningComment(CommentEntity owningComment);
}