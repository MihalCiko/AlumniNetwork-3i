package com.mcode.alumninetwork3i.service.employmentHistoryService;

import com.mcode.alumninetwork3i.dto.EmploymentHistoryDto.EmploymentHistoryDto;
import com.mcode.alumninetwork3i.dto.EmploymentHistoryDto.EmploymentHistoryGetDto;

import java.util.List;
import java.util.UUID;

public interface EmploymentHistoryService {

    EmploymentHistoryGetDto save(EmploymentHistoryDto employmentHistoryDto);
    void delete(UUID id);
    List<EmploymentHistoryGetDto> getAll();
    EmploymentHistoryGetDto getById(UUID id);
    EmploymentHistoryGetDto update(UUID id, EmploymentHistoryDto employmentHistoryDto);
}
