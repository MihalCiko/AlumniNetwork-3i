package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
