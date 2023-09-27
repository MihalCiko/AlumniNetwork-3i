package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.Comment;
import com.mcode.alumninetwork3i.entity.Notification;
import com.mcode.alumninetwork3i.entity.Post;
import com.mcode.alumninetwork3i.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findByReceiverAndOwningPostAndType(User receiver, Post owningPost, String type);

    List<Notification> findNotificationsByReceiver(User receiver, Pageable pageable);

    List<Notification> findNotificationsByReceiverAndIsSeenIsFalse(User receiver);

    List<Notification> findNotificationsByReceiverAndIsReadIsFalse(User receiver);

    void deleteNotificationByOwningPost(Post owningPost);

    void deleteNotificationByOwningComment(Comment owningComment);
}