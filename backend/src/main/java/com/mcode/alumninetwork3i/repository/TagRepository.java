package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    Optional<TagEntity> findTagByName(String name);
}