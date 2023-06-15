package com.mcode.alumninetwork3i.repository;


import com.mcode.alumninetwork3i.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findAllByFirstName(String firstName);
}
