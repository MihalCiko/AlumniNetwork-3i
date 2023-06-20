package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class EmploymentHistoryEntity extends BaseEntity {

    private String company;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(length = 1500)
    private String description;

    @ManyToOne
    private UserEntity user;
}
