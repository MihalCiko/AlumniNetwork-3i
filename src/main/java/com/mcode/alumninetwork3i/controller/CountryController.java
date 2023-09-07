package com.mcode.alumninetwork3i.controller;

import com.mcode.alumninetwork3i.entity.CountryEntity;
import com.mcode.alumninetwork3i.service.countryService.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<?> getCountryList() {
        List<CountryEntity> countryList = countryService.getCountryList();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
}