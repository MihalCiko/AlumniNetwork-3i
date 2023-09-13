package com.mcode.alumninetwork3i.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    protected Long id;
}
