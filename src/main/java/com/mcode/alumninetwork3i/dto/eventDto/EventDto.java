package com.mcode.alumninetwork3i.dto.eventDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventDto {

    private String tittle;

    private LocalDate datePosted;

    private LocalDateTime timePosted;

    private String location;

    private String description;

}
