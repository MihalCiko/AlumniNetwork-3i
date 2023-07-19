package com.mcode.alumninetwork3i.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employment_history")
@NoArgsConstructor
public class EmploymentHistoryEntity extends BaseEntity {

    private String company;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;

    @Column(length = 1500)
    private String description;

    @ManyToOne
    private UserEntity user;

    public EmploymentHistoryEntity(String company,
                                   Date startDate,
                                   Date endDate,
                                   String description) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}
