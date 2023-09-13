package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.response.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentEntity getCommentById(Long commentId);

    CommentEntity createNewComment(String content, PostEntity post);

    CommentEntity updateComment(Long commentId, String content);

    CommentEntity likeComment(Long commentId);

    CommentEntity unlikeComment(Long commentId);

    void deleteComment(Long commentId);

    List<CommentResponse> getPostCommentsPaginate(PostEntity post, Integer page, Integer size);
}