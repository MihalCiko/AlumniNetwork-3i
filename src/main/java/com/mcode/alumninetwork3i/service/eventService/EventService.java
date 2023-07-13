package com.mcode.alumninetwork3i.service.eventService;

import com.mcode.alumninetwork3i.dto.eventDto.EventDto;
import com.mcode.alumninetwork3i.dto.eventDto.EventGetDto;

import java.util.List;
import java.util.UUID;

public interface EventService {

    EventGetDto save(EventDto eventDto);

    void delete(UUID id);

    List<EventGetDto> getAll();

    EventGetDto getById(UUID id);

    EventGetDto update(UUID id, EventDto eventDto);

}
