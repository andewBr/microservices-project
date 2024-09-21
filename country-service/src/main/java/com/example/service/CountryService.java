package com.example.service;

import com.example.entity.Country;
import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }
}
