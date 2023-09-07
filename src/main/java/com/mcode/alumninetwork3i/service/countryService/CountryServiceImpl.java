package com.mcode.alumninetwork3i.service.countryService;

import com.mcode.alumninetwork3i.entity.CountryEntity;
import com.mcode.alumninetwork3i.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public CountryEntity getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public CountryEntity getCountryByName(String name) {
        return countryRepository.findByName(name).orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public List<CountryEntity> getCountryList() {
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
