package com.mcode.alumninetwork3i.mapper;

import com.mcode.alumninetwork3i.dto.UpdateUserInfoDto;
import com.mcode.alumninetwork3i.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapStructMapper {
    User userUpdateDtoToUser(UpdateUserInfoDto updateUserInfoDto);
}