package com.mcode.alumninetwork3i.service;

import com.mcode.alumninetwork3i.entity.Country;

import java.util.List;

public interface CountryService {
    Country getCountryById(Long id);

    Country getCountryByName(String name);

    List<Country> getCountryList();
}