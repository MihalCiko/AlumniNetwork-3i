package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.dto.TagDto;
import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.TagEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.response.PostResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    PostEntity getPostById(Long postId);

    PostResponse getPostResponseById(Long postId);

    List<PostResponse> getPostsByUserPaginate(UserEntity author, Integer page, Integer size);

    List<PostResponse> getTimelinePostsPaginate(Integer page, Integer size);

    List<PostResponse> getPostSharesPaginate(PostEntity sharedPost, Integer page, Integer size);

    List<PostResponse> getPostByTagPaginate(TagEntity tag, Integer page, Integer size);

    PostEntity createNewPost(String content, MultipartFile postPhoto, List<TagDto> postTags);

    PostEntity updatePost(Long postId, String content, MultipartFile postPhoto, List<TagDto> postTags);

    void deletePost(Long postId);

    void deletePostPhoto(Long postId);

    void likePost(Long postId);

    void unlikePost(Long postId);

    CommentEntity createPostComment(Long postId, String content);

    CommentEntity updatePostComment(Long commentId, Long postId, String content);

    void deletePostComment(Long commentId, Long postId);

    PostEntity createPostShare(String content, Long postShareId);

    PostEntity updatePostShare(String content, Long postShareId);

    void deletePostShare(Long postShareId);
}