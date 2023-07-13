package com.mcode.alumninetwork3i.service.employmentHistoryService;

import com.mcode.alumninetwork3i.dto.employmentHistoryDto.EmploymentHistoryDto;
import com.mcode.alumninetwork3i.dto.employmentHistoryDto.EmploymentHistoryGetDto;
import com.mcode.alumninetwork3i.entity.EmploymentHistoryEntity;
import com.mcode.alumninetwork3i.repository.EmploymentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmploymentHistoryImplementation implements EmploymentHistoryService {

    private final EmploymentHistoryRepository employmentHistoryRepository;


    @Override
    public EmploymentHistoryGetDto save(EmploymentHistoryDto employmentHistoryDto) {
        var employmentHistoryEntity = new EmploymentHistoryEntity(
                employmentHistoryDto.getCompany(),
                employmentHistoryDto.getStartDate(),
                employmentHistoryDto.getEndDate(),
                employmentHistoryDto.getDescription()
        );
        var saved = employmentHistoryRepository.save(employmentHistoryEntity);
        return map(saved);
    }

    @Override
    public void delete(UUID id) {
        employmentHistoryRepository.deleteById(id);
    }

    @Override
    public List<EmploymentHistoryGetDto> getAll() {
        return employmentHistoryRepository.findAll()
                .stream()
                .map(employmentHistory -> map((EmploymentHistoryEntity) employmentHistory))
                .collect(Collectors.toList());
    }

    @Override
    public EmploymentHistoryGetDto getById(UUID id) {
        var optional = employmentHistoryRepository.findById(id);
        return optional.map(this::map).orElse(null);
    }

    @Override
    public EmploymentHistoryGetDto update(UUID id, EmploymentHistoryDto employmentHistoryDto) {
        var user = employmentHistoryRepository.findById(id).orElseThrow(RuntimeException::new);
        user.setCompany(employmentHistoryDto.getCompany());
        var saved = employmentHistoryRepository.save(user);
        return map(saved);
    }

    private EmploymentHistoryGetDto map(EmploymentHistoryEntity saved) {
        var getDto = new EmploymentHistoryGetDto();
        getDto.setId(saved.getId());
        getDto.setCompany(saved.getCompany());
        getDto.setStartDate(saved.getStartDate());
        getDto.setEndDate(saved.getEndDate());
        getDto.setDescription(saved.getDescription());
        return getDto;
    }
}
