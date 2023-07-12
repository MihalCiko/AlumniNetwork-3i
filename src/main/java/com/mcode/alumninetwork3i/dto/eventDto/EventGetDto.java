package com.mcode.alumninetwork3i.dto.eventDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventGetDto extends EventDto{

    private UUID id;
}
