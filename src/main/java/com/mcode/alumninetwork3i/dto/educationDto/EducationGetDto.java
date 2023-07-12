package com.mcode.alumninetwork3i.dto.educationDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class EducationGetDto extends EducationDto{

    private UUID id;
}
