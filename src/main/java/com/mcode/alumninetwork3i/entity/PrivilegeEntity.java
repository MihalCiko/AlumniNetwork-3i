package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Collection;

@Entity
public class PrivilegeEntity extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<RoleEntity> roles;
}
