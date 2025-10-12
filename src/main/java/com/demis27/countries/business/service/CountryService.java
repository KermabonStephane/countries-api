package com.demis27.countries.business.service;

import com.demis27.countries.domain.model.Country;
import com.demis27.countries.infrastructure.jpa.mapper.CountryEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.CountryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryEntityRepository repository;
    private final CountryEntityMapper mapper;

    public List<Country> getAllCountries() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
