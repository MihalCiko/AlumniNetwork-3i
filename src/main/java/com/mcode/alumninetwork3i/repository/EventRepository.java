package com.mcode.alumninetwork3i.repository;

import com.mcode.alumninetwork3i.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {
}
