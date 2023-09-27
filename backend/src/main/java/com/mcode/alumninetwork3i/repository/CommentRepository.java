package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.Comment;
import com.mcode.alumninetwork3i.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post, Pageable pageable);
}
