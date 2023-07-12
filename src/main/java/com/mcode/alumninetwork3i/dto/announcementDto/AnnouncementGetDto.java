package com.mcode.alumninetwork3i.dto.announcementDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
public class AnnouncementGetDto extends AnnouncementDto{

    private UUID id;
}
