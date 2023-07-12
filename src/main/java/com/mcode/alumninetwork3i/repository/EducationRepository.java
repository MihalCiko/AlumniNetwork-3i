package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EducationRepository extends JpaRepository<EducationEntity, UUID> {
}
