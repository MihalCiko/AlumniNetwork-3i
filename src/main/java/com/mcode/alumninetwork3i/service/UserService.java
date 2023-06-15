package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.dto.UserDto;
import com.mcode.alumninetwork3i.dto.UserGetDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserGetDto save(UserDto userDto);
    void delete(UUID id);
    List<UserGetDto> getAll();
    UserGetDto getById(UUID id);
    UserGetDto update(UUID id, UserDto userDto);
    List<UserGetDto> findAllByFirstName(String firstName);
}
