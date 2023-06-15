package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    protected UUID id = UUID.randomUUID();
}
