package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.NotificationEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    Optional<NotificationEntity> findByReceiverAndOwningPostAndType(UserEntity receiver, PostEntity owningPost, String type);

    List<NotificationEntity> findNotificationsByReceiver(UserEntity receiver, Pageable pageable);

    List<NotificationEntity> findNotificationsByReceiverAndIsSeenIsFalse(UserEntity receiver);

    List<NotificationEntity> findNotificationsByReceiverAndIsReadIsFalse(UserEntity receiver);

    void deleteNotificationByOwningPost(PostEntity owningPost);

    void deleteNotificationByOwningComment(CommentEntity owningComment);
}