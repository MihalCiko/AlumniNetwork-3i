package com.mcode.alumninetwork3i.service.userService;

import com.mcode.alumninetwork3i.dto.*;
import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserEntity getUserById(Long userId);

    UserEntity getUserByEmail(String email);

    List<UserResponse> getFollowerUsersPaginate(Long userId, Integer page, Integer size);

    List<UserResponse> getFollowingUsersPaginate(Long userId, Integer page, Integer size);

    UserEntity createNewUser(SignupDto signupDto);

    UserEntity updateUserInfo(UpdateUserInfoDto updateUserInfoDto);

    UserEntity updateEmail(UpdateEmailDto updateEmailDto);

    UserEntity updatePassword(UpdatePasswordDto updatePasswordDto);

    UserEntity updateProfilePhoto(MultipartFile photo);

    UserEntity updateCoverPhoto(MultipartFile photo);

    UserEntity verifyEmail(String token);

    void forgotPassword(String email);

    UserEntity resetPassword(String token, ResetPasswordDto resetPasswordDto);

    void deleteUserAccount();

    void followUser(Long userId);

    void unfollowUser(Long userId);

    UserEntity getAuthenticatedUser();

    List<UserResponse> getUserSearchResult(String key, Integer page, Integer size);

    List<UserEntity> getLikesByPostPaginate(PostEntity post, Integer page, Integer size);

    List<UserEntity> getLikesByCommentPaginate(CommentEntity comment, Integer page, Integer size);
}
