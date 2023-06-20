package com.mcode.alumninetwork3i.dto.UserDto;

import com.mcode.alumninetwork3i.dto.UserDto.UserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserGetDto extends UserDto {
    private UUID id;
}
