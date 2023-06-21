package com.mcode.alumninetwork3i.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "employment_history")
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

    public EmploymentHistoryEntity(String company,
                                   LocalDateTime startDate,
                                   LocalDateTime endDate,
                                   String description) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}
