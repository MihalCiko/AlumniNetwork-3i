package com.mcode.alumninetwork3i.dto.employmentHistoryDto;

import lombok.Data;

import java.util.Date;

@Data
public class EmploymentHistoryDto {

    private String company;

    private Date startDate;

    private Date endDate;

    private String description;
}
