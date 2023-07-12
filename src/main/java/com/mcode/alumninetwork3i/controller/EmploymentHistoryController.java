package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.employmentHistoryDto.EmploymentHistoryDto;
import com.mcode.alumninetwork3i.dto.employmentHistoryDto.EmploymentHistoryGetDto;
import com.mcode.alumninetwork3i.dto.userDto.UserDto;
import com.mcode.alumninetwork3i.dto.userDto.UserGetDto;
import com.mcode.alumninetwork3i.service.employmentHistoryService.EmploymentHistoryService;
import com.mcode.alumninetwork3i.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/empHistory")
@RequiredArgsConstructor
public class EmploymentHistoryController {

    private final EmploymentHistoryService employmentHistoryService;
    private final UserService userService;

    @PostMapping
    public EmploymentHistoryGetDto save(@RequestBody EmploymentHistoryDto employmentHistoryDto) {
        return employmentHistoryService.save(employmentHistoryDto);
    }

    @GetMapping
    public List<EmploymentHistoryGetDto> getAll() {
        return employmentHistoryService.getAll();
    }

    @GetMapping("{userId}")
    public EmploymentHistoryGetDto getById(@PathVariable UUID userId) {
        return employmentHistoryService.getById(userId);
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
