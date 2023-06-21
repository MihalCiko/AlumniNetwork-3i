package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.UserDto.UserDto;
import com.mcode.alumninetwork3i.dto.UserDto.UserGetDto;
import com.mcode.alumninetwork3i.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserGetDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping
    public List<UserGetDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("{userId}")
    public UserGetDto getById(@PathVariable UUID userId) {
        return userService.getById(userId);
    }

    @PatchMapping("{userId}")
    public UserGetDto update(@PathVariable UUID userId, @RequestBody UserDto userDto) {
        return userService.update(userId, userDto);
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable UUID userId) {
        userService.delete(userId);
    }

    @GetMapping("/firstname")
    public List<UserGetDto> findAllByFirstNAme(@RequestParam String firstNAme) {
        return userService.findAllByFirstName(firstNAme);
    }
}
