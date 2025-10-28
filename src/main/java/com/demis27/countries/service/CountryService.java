package com.demis27.countries.service;

import com.demis27.countries.domain.Country;
import com.demis27.countries.infrastructure.jpa.mapper.CountryEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.CountryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryEntityRepository repository;
    private final CountryEntityMapper mapper;

    public List<Country> getAllCountries(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::toDomain).toList();
    }

    public Long countCountries() {
        return repository.count();
    }

    public Optional<Country> getCountry(Integer countryCode) {
        return repository.findById(countryCode).map(mapper::toDomain);
    }

    public List<Country> getAllCountriesByRegion(Integer regionCode) {
        return repository.findCountryByRegionCode(regionCode).stream().map(mapper::toDomain).toList();
    }

    public List<Country> getAllCountriesBySubRegion(Integer subRegionCode) {
        return repository.findCountryBySubRegionCode(subRegionCode).stream().map(mapper::toDomain).toList();
    }
}
