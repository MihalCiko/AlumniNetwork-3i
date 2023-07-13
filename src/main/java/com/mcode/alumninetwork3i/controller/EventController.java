package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.eventDto.EventDto;
import com.mcode.alumninetwork3i.dto.eventDto.EventGetDto;
import com.mcode.alumninetwork3i.dto.userDto.UserDto;
import com.mcode.alumninetwork3i.dto.userDto.UserGetDto;
import com.mcode.alumninetwork3i.service.eventService.EventService;
import com.mcode.alumninetwork3i.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    @PostMapping
    public EventGetDto save(@RequestBody EventDto eventDto){
        return eventService.save(eventDto);
    }

    @GetMapping
    public List<EventGetDto> getAll(){
        return eventService.getAll();
    }
    @GetMapping("{userid}")
    public EventGetDto getById(@PathVariable UUID userid){
        return eventService.getById(userid);
    }
    @PatchMapping("{userid}")
    public UserGetDto update(@PathVariable UUID userid, @RequestBody UserDto userDto){
        return userService.update(userid,userDto);
    }

    @DeleteMapping("{userid}")
    public void delete (@PathVariable UUID userid){
        userService.delete(userid);
    }




}
