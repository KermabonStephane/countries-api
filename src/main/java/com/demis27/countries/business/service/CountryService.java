package com.demis27.countries.business.service;

import com.demis27.countries.domain.model.Country;
import com.demis27.countries.infrastructure.jpa.mapper.CountryEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.CountryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryEntityRepository countriesRepository;
    private final CountryEntityMapper countriesMapper;

    public List<Country> getAllCountries(Pageable pageable) {
        return countriesRepository.findAll(pageable).stream().map(countriesMapper::toDomain).toList();
    }

    public Long countCountries() {
        return countriesRepository.count();
    }
}
