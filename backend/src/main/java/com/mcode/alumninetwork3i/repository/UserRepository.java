package com.mcode.alumninetwork3i.repository;


import com.mcode.alumninetwork3i.entity.CommentEntity;
import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    void deleteByEmail(String email);

    List<UserEntity> findUsersByFollowerUsers(UserEntity user, Pageable pageable);

    List<UserEntity> findUsersByFollowingUsers(UserEntity user, Pageable pageable);

    List<UserEntity> findUsersByLikedPosts(PostEntity post, Pageable pageable);

    List<UserEntity> findUsersByLikedComments(CommentEntity comment, Pageable pageable);

    @Query(value = "select * from users u " +
            "where concat(u.first_name, ' ', u.last_name) like %:name% " +
            "order by u.first_name asc, u.last_name asc",
            nativeQuery = true)
    List<UserEntity> findUsersByName(String name, Pageable pageable);
}
