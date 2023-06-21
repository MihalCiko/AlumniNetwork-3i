package com.mcode.alumninetwork3i.dto.EmploymentHistoryDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmploymentHistoryDto {

    private String company;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
}
