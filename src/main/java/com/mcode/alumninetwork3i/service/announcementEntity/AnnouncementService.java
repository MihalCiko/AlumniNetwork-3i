package com.mcode.alumninetwork3i.service.announcementEntity;

import com.mcode.alumninetwork3i.dto.announcementDto.AnnouncementDto;
import com.mcode.alumninetwork3i.dto.announcementDto.AnnouncementGetDto;

import java.util.List;
import java.util.UUID;

public interface AnnouncementService {

    AnnouncementGetDto save(AnnouncementDto announcementDto);

    void delete(UUID id);

    List<AnnouncementGetDto> getAll();

    AnnouncementGetDto getById(UUID id);

    AnnouncementGetDto update(UUID id, AnnouncementDto announcementDto);
}
