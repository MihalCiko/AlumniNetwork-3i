package com.mcode.alumninetwork3i.service.announcementEntity;

import com.mcode.alumninetwork3i.dto.announcementDto.AnnouncementDto;
import com.mcode.alumninetwork3i.dto.announcementDto.AnnouncementGetDto;
import com.mcode.alumninetwork3i.entity.AnnouncementEntity;
import com.mcode.alumninetwork3i.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImplementation implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Override
    public AnnouncementGetDto save(AnnouncementDto announcementDto) {
        var announcementEntity = new AnnouncementEntity(
                announcementDto.getType(),
                announcementDto.getInformation()
        );
        var saved = announcementRepository.save(announcementEntity);
        return map(saved);
    }


    @Override
    public void delete(UUID id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public List<AnnouncementGetDto> getAll() {
        return announcementRepository.findAll()
                .stream()
                .map(announcement -> map(announcement))
                .collect(Collectors.toList());
    }

    @Override
    public AnnouncementGetDto getById(UUID id) {
        var optional = announcementRepository.findById(id);
        return optional.map(this::map).orElse(null);
    }

    @Override
    public AnnouncementGetDto update(UUID id, AnnouncementDto announcementDto) {
        var announcement = announcementRepository.findById(id).orElseThrow(RuntimeException::new);
        announcement.setType(announcementDto.getType());
        announcement.setInformation(announcementDto.getInformation());
        var saved = announcementRepository.save(announcement);
        return map(saved);
    }

    private AnnouncementGetDto map(AnnouncementEntity saved) {
        var getDto = new AnnouncementGetDto();
        getDto.setId(saved.getId());
        getDto.setType(saved.getType());
        getDto.setInformation(saved.getInformation());
        return getDto;
    }
}
