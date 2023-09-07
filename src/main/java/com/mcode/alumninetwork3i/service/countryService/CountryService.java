package com.mcode.alumninetwork3i.service.countryService;

import com.mcode.alumninetwork3i.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    CountryEntity getCountryById(Long id);

    CountryEntity getCountryByName(String name);

    List<CountryEntity> getCountryList();
}