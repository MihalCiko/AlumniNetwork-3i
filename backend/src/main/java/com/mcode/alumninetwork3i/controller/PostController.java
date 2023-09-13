package com.mcode.alumninetwork3i.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcode.alumninetwork3i.dto.TagDto;
import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.TagEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.exception.EmptyPostException;
import com.mcode.alumninetwork3i.response.CommentResponse;
import com.mcode.alumninetwork3i.response.PostResponse;
import com.mcode.alumninetwork3i.service.CommentService;
import com.mcode.alumninetwork3i.service.PostService;
import com.mcode.alumninetwork3i.service.TagService;
import com.mcode.alumninetwork3i.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;
    private final TagService tagService;

    @PostMapping("/posts/create")
    public ResponseEntity<?> createNewPost(@RequestParam(value = "content", required = false) Optional<String> content,
                                           @RequestParam(name = "postPhoto", required = false) Optional<MultipartFile> postPhoto,
                                           @RequestParam(name = "postTags", required = false) Optional<String> postTags) throws JsonProcessingException {
        if ((content.isEmpty() || content.get().length() <= 0) &&
                (postPhoto.isEmpty() || postPhoto.get().getSize() <= 0)) {
            throw new EmptyPostException();
        }

        ObjectMapper mapper = new ObjectMapper();

        String contentToAdd = content.isEmpty() ? null : content.get();
        MultipartFile postPhotoToAdd = postPhoto.isEmpty() ? null : postPhoto.get();
        List<TagDto> postTagsToAdd = postTags.isEmpty() ? null :
                mapper.readValue(postTags.get(), new TypeReference<>() {});

        PostEntity createdPost = postService.createNewPost(contentToAdd, postPhotoToAdd, postTagsToAdd);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PostMapping("/posts/{postId}/update")
    public ResponseEntity<?> updatePost(@PathVariable("postId") Long postId,
                                        @RequestParam(value = "content", required = false) Optional<String> content,
                                        @RequestParam(name = "postPhoto", required = false) Optional<MultipartFile> postPhoto,
                                        @RequestParam(name = "postTags", required = false) Optional<String> postTags) throws JsonProcessingException {
        if ((content.isEmpty() || content.get().length() <= 0) &&
                (postPhoto.isEmpty() || postPhoto.get().getSize() <= 0)) {
            throw new EmptyPostException();
        }

        ObjectMapper mapper = new ObjectMapper();

        String contentToAdd = content.isEmpty() ? null : content.get();
        MultipartFile postImageToAdd = postPhoto.isEmpty() ? null : postPhoto.get();
        List<TagDto> postTagsToAdd = postTags.isEmpty() ? null :
                mapper.readValue(postTags.get(), new TypeReference<>() {});

        PostEntity updatePost = postService.updatePost(postId, contentToAdd, postImageToAdd, postTagsToAdd);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/delete")
    public ResponseEntity<?> deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/photo/delete")
    public ResponseEntity<?> deletePostPhoto(@PathVariable("postId") Long postId) {
        postService.deletePostPhoto(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable("postId") Long postId) {
        PostResponse foundPostResponse = postService.getPostResponseById(postId);
        return new ResponseEntity<>(foundPostResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/likes")
    public ResponseEntity<?> getPostLikes(@PathVariable("postId") Long postId,
                                          @RequestParam("page") Integer page,
                                          @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page-1;
        size = size <= 0 ? 5 : size;
        PostEntity targetPost = postService.getPostById(postId);
        List<UserEntity> postLikerList = userService.getLikesByPostPaginate(targetPost, page, size);
        return new ResponseEntity<>(postLikerList, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/shares")
    public ResponseEntity<?> getPostShares(@PathVariable("postId") Long postId,
                                           @RequestParam("page") Integer page,
                                           @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page-1;
        size = size <= 0 ? 5 : size;
        PostEntity sharedPost = postService.getPostById(postId);
        List<PostResponse> foundPostShares = postService.getPostSharesPaginate(sharedPost, page, size);
        return new ResponseEntity<>(foundPostShares, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable("postId") Long postId) {
        postService.likePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/unlike")
    public ResponseEntity<?> unlikePost(@PathVariable("postId") Long postId) {
        postService.unlikePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<?> getPostComments(@PathVariable("postId") Long postId,
                                             @RequestParam("page") Integer page,
                                             @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page-1;
        size = size <= 0 ? 5 : size;
        PostEntity targetPost = postService.getPostById(postId);
        List<CommentResponse> postCommentResponseList = commentService.getPostCommentsPaginate(targetPost, page, size);
        return new ResponseEntity<>(postCommentResponseList, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments/create")
    public ResponseEntity<?> createPostComment(@PathVariable("postId") Long postId,
                                               @RequestParam(value = "content") String content) {
        CommentEntity savedComment = postService.createPostComment(postId, content);
        CommentResponse commentResponse = CommentResponse.builder()
                .comment(savedComment)
                .likedByAuthUser(false)
                .build();
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments/{commentId}/update")
    public ResponseEntity<?> updatePostComment(@PathVariable("commentId") Long commentId,
                                               @PathVariable("postId") Long postId,
                                               @RequestParam(value = "content") String content) {
        CommentEntity savedComment = postService.updatePostComment(commentId, postId, content);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments/{commentId}/delete")
    public ResponseEntity<?> deletePostComment(@PathVariable("commentId") Long commentId,
                                               @PathVariable("postId") Long postId) {
        postService.deletePostComment(commentId, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/posts/comments/{commentId}/like")
    public ResponseEntity<?> likePostComment(@PathVariable("commentId") Long commentId) {
        commentService.likeComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/posts/comments/{commentId}/unlike")
    public ResponseEntity<?> unlikePostComment(@PathVariable("commentId") Long commentId) {
        commentService.unlikeComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts/comments/{commentId}/likes")
    public ResponseEntity<?> getCommentLikeList(@PathVariable("commentId") Long commentId,
                                                @RequestParam("page") Integer page,
                                                @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page-1;
        size = size <= 0 ? 5 : size;
        CommentEntity targetComment = commentService.getCommentById(commentId);
        List<UserEntity> commentLikes = userService.getLikesByCommentPaginate(targetComment, page, size);
        return new ResponseEntity<>(commentLikes, HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/share/create")
    public ResponseEntity<?> createPostShare(@PathVariable("postId") Long postId,
                                             @RequestParam(value = "content", required = false) Optional<String> content) {
        String contentToAdd = content.isEmpty() ? null : content.get();
        PostEntity postShare = postService.createPostShare(contentToAdd, postId);
        return new ResponseEntity<>(postShare, HttpStatus.OK);
    }

    @PostMapping("/posts/{postShareId}/share/update")
    public ResponseEntity<?> updatePostShare(@PathVariable("postShareId") Long postShareId,
                                             @RequestParam(value = "content", required = false) Optional<String> content) {
        String contentToAdd = content.isEmpty() ? null : content.get();
        PostEntity updatedPostShare = postService.updatePostShare(contentToAdd, postShareId);
        return new ResponseEntity<>(updatedPostShare, HttpStatus.OK);
    }

    @PostMapping("/posts/{postShareId}/share/delete")
    public ResponseEntity<?> deletePostShare(@PathVariable("postShareId") Long postShareId) {
        postService.deletePostShare(postShareId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts/tags/{tagName}")
    public ResponseEntity<?> getPostsByTag(@PathVariable("tagName") String tagName,
                                           @RequestParam("page") Integer page,
                                           @RequestParam("size") Integer size) {
        page = page < 0 ? 0 : page-1;
        size = size <= 0 ? 5 : size;
        TagEntity targetTag = tagService.getTagByName(tagName);
        List<PostResponse> taggedPosts = postService.getPostByTagPaginate(targetTag, page, size);
        return new ResponseEntity<>(taggedPosts, HttpStatus.OK);
    }
}