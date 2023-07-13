package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.educationDto.EducationDto;
import com.mcode.alumninetwork3i.dto.educationDto.EducationGetDto;
import com.mcode.alumninetwork3i.service.educationService.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @PostMapping
    public EducationGetDto save(@RequestBody EducationDto educationDto) {
        return educationService.save(educationDto);
    }

    @GetMapping
    public List<EducationGetDto> getAll() {
        return educationService.getAll();
    }

    @GetMapping("{educationId}")
    public EducationGetDto getById(@PathVariable UUID educationId) {
        return educationService.getById(educationId);
    }

    @PatchMapping("{educationId}")
    public EducationGetDto update(@PathVariable UUID educationId, @RequestBody EducationDto educationDto) {
        return educationService.update(educationId, educationDto);
    }

    @DeleteMapping("{educationId}")
    public void delete(@PathVariable UUID educationId) {
        educationService.delete(educationId);
    }
}
