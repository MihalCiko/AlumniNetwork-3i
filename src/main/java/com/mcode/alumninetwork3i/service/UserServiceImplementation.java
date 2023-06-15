package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.dto.UserDto;
import com.mcode.alumninetwork3i.dto.UserGetDto;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{

    private final UserRepository userRepository;
    @Override
    public UserGetDto save(UserDto userDto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<UserGetDto> getAll() {
        return null;
    }

    @Override
    public UserGetDto getById(UUID id) {
        return null;
    }

    @Override
    public UserGetDto update(UUID id, UserDto userDto) {
        return null;
    }

    private UserGetDto map(UserEntity saved) {
        var getDto = new UserGetDto();
        getDto.setId(saved.getId());
        getDto.setFirstName(saved.getFirstName());
        getDto.setLastName(saved.getLastName());
        getDto.setEmail(saved.getEmail());
        getDto.setGender(saved.getGender());
        return getDto;
    }

    public List<UserGetDto> findAllByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}


