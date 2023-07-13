package com.mcode.alumninetwork3i.service.eventService;

import com.mcode.alumninetwork3i.dto.eventDto.EventDto;
import com.mcode.alumninetwork3i.dto.eventDto.EventGetDto;
import com.mcode.alumninetwork3i.entity.EventEntity;
import com.mcode.alumninetwork3i.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImplementation implements EventService {

    private final EventRepository eventRepository;

    @Override
    public EventGetDto save(EventDto eventDto) {
        var EventEntity = new EventEntity(eventDto.getTittle(), eventDto.getDatePosted(), eventDto.getTimePosted(), eventDto.getLocation(), eventDto.getDescription());
        var saved = eventRepository.save(EventEntity);
        return map(saved);

    }

    @Override
    public void delete(UUID id) {
        eventRepository.deleteById(id);

    }

    @Override
    public List<EventGetDto> getAll() {

        return eventRepository.findAll()
                .stream()
                .map(events -> map((EventEntity) events))
                .collect(Collectors.toList());
    }

    @Override
    public EventGetDto getById(UUID id) {
        var optional = eventRepository.findById(id);
        return optional.map(this::map).orElse(null);
    }

    @Override
    public EventGetDto update(UUID id, EventDto eventDto) {
        var event = eventRepository.findById(id).orElseThrow(RuntimeException::new);
        event.setTittle(eventDto.getTittle());
        var saved = eventRepository.save(event);
        return map(saved);
    }

    private EventGetDto map(EventEntity saved) {
        var getDto = new EventGetDto();
        getDto.setId(saved.getId());
        getDto.setTittle(saved.getTittle());
        getDto.setDatePosted(saved.getDatePosted());
        getDto.setTimePosted(saved.getTimePosted());
        getDto.setLocation(saved.getLocation());
        getDto.setDescription(saved.getDescription());
        return getDto;
    }
}

