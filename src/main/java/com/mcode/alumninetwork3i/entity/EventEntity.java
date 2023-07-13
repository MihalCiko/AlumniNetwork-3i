package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "events")
public class EventEntity extends BaseEntity {

    private String tittle;

    private LocalDate datePosted;

    private LocalDateTime timePosted;

    private String location;

    private String description;


    @ManyToMany(mappedBy = "appliedEvents")
    Set<UserEntity> apply;

    public EventEntity(String tittle,
                       LocalDate datePosted,
                       LocalDateTime timePosted,
                       String location,
                       String description) {
        this.tittle = tittle;
        this.datePosted = datePosted;
        this.timePosted = timePosted;
        this.location = location;
        this.description = description;
    }
}
