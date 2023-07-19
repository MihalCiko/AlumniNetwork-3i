package com.mcode.alumninetwork3i.dto.roleDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleGetDto extends RoleDto {

    private UUID id;
}
