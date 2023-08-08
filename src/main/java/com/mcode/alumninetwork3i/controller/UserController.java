package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.userDto.UserDto;
import com.mcode.alumninetwork3i.dto.userDto.UserGetDto;
import com.mcode.alumninetwork3i.entity.UserEntity;
import com.mcode.alumninetwork3i.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/home")
    public ModelAndView home(@RequestParam(value = "search", required = false) String searchQuery) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Welcome to your page!");

        List<UserEntity> users;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            // Perform the search based on the searchQuery
            users = this.userService.fetchAllUsersFilterBy(searchQuery);
        } else {
            // Fetch all users if no search query is provided
            users = this.userService.fetchAllUsers();
        }

        modelAndView.addObject("users", users);
        return modelAndView;
    }

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
