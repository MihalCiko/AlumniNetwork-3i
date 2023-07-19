package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.PrivilegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, UUID> {
}
