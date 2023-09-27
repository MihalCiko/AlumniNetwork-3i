package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.Comment;
import com.mcode.alumninetwork3i.entity.Notification;
import com.mcode.alumninetwork3i.entity.Post;
import com.mcode.alumninetwork3i.entity.User;

import java.util.List;

public interface NotificationService {
    Notification getNotificationById(Long notificationId);

    Notification getNotificationByReceiverAndOwningPostAndType(User receiver, Post owningPost, String type);

    void sendNotification(User receiver, User sender, Post owningPost, Comment owningComment, String type);

    void removeNotification(User receiver, Post owningPost, String type);

    List<Notification> getNotificationsForAuthUserPaginate(Integer page, Integer size);

    void markAllSeen();

    void markAllRead();

    void deleteNotification(User receiver, Post owningPost, String type);

    void deleteNotificationByOwningPost(Post owningPost);

    void deleteNotificationByOwningComment(Comment owningComment);
}