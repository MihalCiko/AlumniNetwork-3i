package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.Comment;
import com.mcode.alumninetwork3i.entity.Post;
import com.mcode.alumninetwork3i.response.CommentResponse;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long commentId);

    Comment createNewComment(String content, Post post);

    Comment updateComment(Long commentId, String content);

    Comment likeComment(Long commentId);

    Comment unlikeComment(Long commentId);

    void deleteComment(Long commentId);

    List<CommentResponse> getPostCommentsPaginate(Post post, Integer page, Integer size);
}