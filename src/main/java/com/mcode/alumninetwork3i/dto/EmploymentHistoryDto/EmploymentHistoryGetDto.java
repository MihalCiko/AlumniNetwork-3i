package com.mcode.alumninetwork3i.dto.EmploymentHistoryDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmploymentHistoryGetDto extends EmploymentHistoryDto{
    private UUID id;
}
