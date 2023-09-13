package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.enums.NotificationType;
import com.mcode.alumninetwork3i.exception.CommentNotFoundException;
import com.mcode.alumninetwork3i.exception.InvalidOperationException;
import com.mcode.alumninetwork3i.repository.CommentRepository;
import com.mcode.alumninetwork3i.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final NotificationService notificationService;

    @Override
    public CommentEntity getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
    }

    @Override
    public CommentEntity createNewComment(String content, PostEntity post) {
        UserEntity authUser = userService.getAuthenticatedUser();
        CommentEntity newComment = new CommentEntity();
        newComment.setContent(content);
        newComment.setAuthor(authUser);
        newComment.setPost(post);
        newComment.setLikeCount(0);
        newComment.setDateCreated(new Date());
        newComment.setDateLastModified(new Date());
        return commentRepository.save(newComment);
    }

    @Override
    public CommentEntity updateComment(Long commentId, String content) {
        UserEntity authUser = userService.getAuthenticatedUser();
        CommentEntity targetComment = getCommentById(commentId);
        if (targetComment.getAuthor().equals(authUser)) {
            targetComment.setContent(content);
            targetComment.setDateLastModified(new Date());
            return commentRepository.save(targetComment);
        } else {
            throw new InvalidOperationException();
        }
    }

    @Override
    public void deleteComment(Long commentId) {
        UserEntity authUser = userService.getAuthenticatedUser();
        CommentEntity targetComment = getCommentById(commentId);
        if (targetComment.getAuthor().equals(authUser)) {
            commentRepository.deleteById(commentId);
            notificationService.deleteNotificationByOwningComment(targetComment);
        } else {
            throw new InvalidOperationException();
        }
    }

    @Override
    public CommentEntity likeComment(Long commentId) {
        UserEntity authUser = userService.getAuthenticatedUser();
        CommentEntity targetComment = getCommentById(commentId);
        if (!targetComment.getLikeList().contains(authUser)) {
            targetComment.setLikeCount(targetComment.getLikeCount() + 1);
            targetComment.getLikeList().add(authUser);
            targetComment.setDateLastModified(new Date());
            CommentEntity updatedComment = commentRepository.save(targetComment);

            if (!targetComment.getAuthor().equals(authUser)) {
                notificationService.sendNotification(
                        targetComment.getAuthor(),
                        authUser,
                        targetComment.getPost(),
                        targetComment,
                        NotificationType.COMMENT_LIKE.name()
                );
            }

            return updatedComment;
        } else {
            throw new InvalidOperationException();
        }
    }

    @Override
    public CommentEntity unlikeComment(Long commentId) {
        UserEntity authUser = userService.getAuthenticatedUser();
        CommentEntity targetComment = getCommentById(commentId);
        if (targetComment.getLikeList().contains(authUser)) {
            targetComment.setLikeCount(targetComment.getLikeCount() - 1);
            targetComment.getLikeList().remove(authUser);
            targetComment.setDateLastModified(new Date());
            CommentEntity updatedComment = commentRepository.save(targetComment);

            if (!targetComment.getAuthor().equals(authUser)) {
                notificationService.removeNotification(
                        targetComment.getPost().getAuthor(),
                        targetComment.getPost(),
                        NotificationType.COMMENT_LIKE.name()
                );
            }

            return updatedComment;
        } else {
            throw new InvalidOperationException();
        }
    }

    @Override
    public List<CommentResponse> getPostCommentsPaginate(PostEntity post, Integer page, Integer size) {
        UserEntity authUser = userService.getAuthenticatedUser();
        List<CommentEntity> foundCommentList = commentRepository.findByPost(
                post,
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dateCreated"))
        );

        List<CommentResponse> commentResponseList = new ArrayList<>();
        foundCommentList.forEach(comment -> {
            CommentResponse newCommentResponse = CommentResponse.builder()
                    .comment(comment)
                    .likedByAuthUser(comment.getLikeList().contains(authUser))
                    .build();
            commentResponseList.add(newCommentResponse);
        });

        return commentResponseList;
    }
}