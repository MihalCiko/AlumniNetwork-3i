package com.mcode.alumninetwork3i.repository;


import com.mcode.alumninetwork3i.entity.PostEntity;
import com.mcode.alumninetwork3i.entity.TagEntity;
import com.mcode.alumninetwork3i.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findPostsByAuthor(UserEntity author, Pageable pageable);

    List<PostEntity> findPostsByAuthorIdIn(List<Long> followingUserIds, Pageable pageable);

    List<PostEntity> findPostsBySharedPost(PostEntity post, Pageable pageable);

    List<PostEntity> findPostsByPostTags(TagEntity tag, Pageable pageable);
}

