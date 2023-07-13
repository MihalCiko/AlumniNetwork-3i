package com.mcode.alumninetwork3i.service.educationService;

import com.mcode.alumninetwork3i.dto.educationDto.EducationDto;
import com.mcode.alumninetwork3i.dto.educationDto.EducationGetDto;
import com.mcode.alumninetwork3i.entity.EducationEntity;
import com.mcode.alumninetwork3i.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationServiceImplementation implements EducationService {

    private final EducationRepository educationRepository;

    @Override
    public EducationGetDto save(EducationDto educationDto) {
        var educationEntity = new EducationEntity(
                educationDto.getSchoolName(),
                educationDto.getDegree(),
                educationDto.getTypeOfStudy(),
                educationDto.getStartDate(),
                educationDto.getEndDate()
        );
        var saved = educationRepository.save(educationEntity);
        return map(saved);
    }

    @Override
    public void delete(UUID id) {
        educationRepository.deleteById(id);
    }

    @Override
    public List<EducationGetDto> getAll() {
        return educationRepository.findAll()
                .stream()
                .map(education -> map(education))
                .collect(Collectors.toList());
    }

    @Override
    public EducationGetDto getById(UUID id) {
        var optional = educationRepository.findById(id);
        return optional.map(this::map).orElse(null);
    }

    @Override
    public EducationGetDto update(UUID id, EducationDto educationDto) {
        var education = educationRepository.findById(id).orElseThrow(RuntimeException::new);
        education.setSchoolName(educationDto.getSchoolName());
        education.setDegree(education.getDegree());
        education.setTypeOfStudy(education.getTypeOfStudy());
        education.setStartDate(education.getStartDate());
        education.setEndDate(education.getEndDate());
        var saved = educationRepository.save(education);
        return map(saved);
    }

    private EducationGetDto map(EducationEntity saved) {
        var getDto = new EducationGetDto();
        getDto.setId(saved.getId());
        getDto.setSchoolName(saved.getSchoolName());
        getDto.setDegree(saved.getDegree());
        getDto.setTypeOfStudy(saved.getTypeOfStudy());
        getDto.setStartDate(saved.getStartDate());
        getDto.setEndDate(saved.getEndDate());
        return getDto;
    }
}
