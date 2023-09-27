package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.dto.*;
import com.mcode.alumninetwork3i.entity.Comment;
import com.mcode.alumninetwork3i.entity.Post;
import com.mcode.alumninetwork3i.entity.User;
import com.mcode.alumninetwork3i.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);

    User getUserByEmail(String email);

    List<UserResponse> getFollowerUsersPaginate(Long userId, Integer page, Integer size);

    List<UserResponse> getFollowingUsersPaginate(Long userId, Integer page, Integer size);

    User createNewUser(SignupDto signupDto);

    User updateUserInfo(UpdateUserInfoDto updateUserInfoDto);

    User updateEmail(UpdateEmailDto updateEmailDto);

    User updatePassword(UpdatePasswordDto updatePasswordDto);

    User updateProfilePhoto(MultipartFile photo);

    User updateCoverPhoto(MultipartFile photo);

    User verifyEmail(String token);

    void forgotPassword(String email);

    User resetPassword(String token, ResetPasswordDto resetPasswordDto);

    void deleteUserAccount();

    void followUser(Long userId);

    void unfollowUser(Long userId);

    User getAuthenticatedUser();

    List<UserResponse> getUserSearchResult(String key, Integer page, Integer size);

    List<User> getLikesByPostPaginate(Post post, Integer page, Integer size);

    List<User> getLikesByCommentPaginate(Comment comment, Integer page, Integer size);
}
