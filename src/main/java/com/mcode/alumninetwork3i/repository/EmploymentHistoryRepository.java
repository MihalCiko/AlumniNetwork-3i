package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.EmploymentHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistoryEntity, UUID> {
}
