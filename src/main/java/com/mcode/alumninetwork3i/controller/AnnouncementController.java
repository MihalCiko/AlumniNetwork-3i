package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.dto.announcementDto.AnnouncementDto;
import com.mcode.alumninetwork3i.dto.announcementDto.AnnouncementGetDto;
import com.mcode.alumninetwork3i.service.announcementEntity.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/announcements")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping
    public AnnouncementGetDto save(@RequestBody AnnouncementDto announcementDto) {
        return announcementService.save(announcementDto);
    }

    @GetMapping
    public List<AnnouncementGetDto> getAll() {
        return announcementService.getAll();
    }

    @GetMapping("{announcementId}")
    public AnnouncementGetDto getById(@PathVariable UUID announcementId) {
        return announcementService.getById(announcementId);
    }

    @PatchMapping("{announcementId}")
    public AnnouncementGetDto update(@PathVariable UUID announcementId, @RequestBody AnnouncementDto announcementDto) {
        return announcementService.update(announcementId, announcementDto);
    }

    @DeleteMapping("{announcementId}")
    public void delete(@PathVariable UUID announcementId) {
        announcementService.delete(announcementId);
    }
}
