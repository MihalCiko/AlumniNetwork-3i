package com.mcode.alumninetwork3i.dto.privilegeDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class PrivilegeGetDto extends PrivilegeDto {

    private UUID id;
}
