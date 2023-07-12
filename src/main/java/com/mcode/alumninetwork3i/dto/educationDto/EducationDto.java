package com.mcode.alumninetwork3i.dto.educationDto;

import lombok.Data;

import java.util.Date;

@Data
public class EducationDto {

    private String schoolName;

    private String degree;

    private String typeOfStudy;

    private Date startDate;

    private Date endDate;
}
