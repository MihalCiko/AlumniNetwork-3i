package com.mcode.alumninetwork3i.service.educationService;

import com.mcode.alumninetwork3i.dto.educationDto.EducationDto;
import com.mcode.alumninetwork3i.dto.educationDto.EducationGetDto;

import java.util.List;
import java.util.UUID;

public interface EducationService {

    EducationGetDto save(UUID userId, EducationDto educationDto);

    EducationGetDto save(EducationDto educationDto);

    void delete(UUID id);

    List<EducationGetDto> getAll();

    EducationGetDto getById(UUID id);

    EducationGetDto update(UUID id, EducationDto educationDto);
}
