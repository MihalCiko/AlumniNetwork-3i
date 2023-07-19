package com.mcode.alumninetwork3i.service.userService;

import com.mcode.alumninetwork3i.dto.userDto.UserDto;
import com.mcode.alumninetwork3i.dto.userDto.UserGetDto;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserGetDto save(UserDto userDto) {
        var userEntity = new UserEntity(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getDateOfBirth(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhoneNumber(),
                userDto.getGender(),
                userDto.getSkills(),
                userDto.getInterest(),
                userDto.getLocation(),
                userDto.getBio()
        );
        var saved = userRepository.save(userEntity);
        return map(saved);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserGetDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> map(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserGetDto getById(UUID id) {
        var optional = userRepository.findById(id);
        return optional.map(this::map).orElse(null);
    }

    @Override
    public UserGetDto update(UUID id, UserDto userDto) {
        var user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        user.setFirstName(userDto.getFirstName());
        var saved = userRepository.save(user);
        return map(saved);
    }

    private UserGetDto map(UserEntity saved) {
        var getDto = new UserGetDto();
        getDto.setId(saved.getId());
        getDto.setFirstName(saved.getFirstName());
        getDto.setLastName(saved.getLastName());
        getDto.setDateOfBirth(saved.getDateOfBirth());
        getDto.setEmail(saved.getEmail());
        getDto.setPhoneNumber(saved.getPhoneNumber());
        getDto.setGender(saved.getGender());
        getDto.setInterest(saved.getInterest());
        getDto.setSkills(saved.getSkills());
        getDto.setLocation(saved.getLocation());
        getDto.setBio(saved.getBio());
        return getDto;
    }

    public List<UserGetDto> findAllByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity findEntity(UUID userId) {
        return null;
    }
}


