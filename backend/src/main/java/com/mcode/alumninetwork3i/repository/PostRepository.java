package com.mcode.alumninetwork3i.repository;


import com.mcode.alumninetwork3i.entity.Post;
import com.mcode.alumninetwork3i.entity.Tag;
import com.mcode.alumninetwork3i.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByAuthor(User author, Pageable pageable);

    List<Post> findPostsByAuthorIdIn(List<Long> followingUserIds, Pageable pageable);

    List<Post> findPostsBySharedPost(Post post, Pageable pageable);

    List<Post> findPostsByPostTags(Tag tag, Pageable pageable);
}

