package com.mcode.alumninetwork3i.mapper;

import com.mcode.alumninetwork3i.dto.UpdateUserInfoDto;
import com.mcode.alumninetwork3i.entity.UserEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapStructMapper {
    UserEntity userUpdateDtoToUser(UpdateUserInfoDto updateUserInfoDto);
}