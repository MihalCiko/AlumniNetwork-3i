package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.eventDto.EventDto;
import com.mcode.alumninetwork3i.dto.eventDto.EventGetDto;
import com.mcode.alumninetwork3i.service.eventService.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;


    @PostMapping
    public EventGetDto save(@RequestBody EventDto eventDto) {
        return eventService.save(eventDto);
    }

    @GetMapping
    public List<EventGetDto> getAll() {
        return eventService.getAll();
    }

    @GetMapping("{eventId}")
    public EventGetDto getById(@PathVariable UUID eventId) {
        return eventService.getById(eventId);
    }

    @PatchMapping("{eventId}")
    public EventGetDto update(@PathVariable UUID eventId, @RequestBody EventDto eventDto) {
        return eventService.update(eventId, eventDto);
    }

    @DeleteMapping("{eventId}")
    public void delete(@PathVariable UUID eventId) {
        eventService.delete(eventId);
    }


}
