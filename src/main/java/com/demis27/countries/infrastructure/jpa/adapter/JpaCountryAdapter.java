package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceAdapter;
import com.demis27.countries.domain.Country;
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity;
import com.demis27.countries.infrastructure.jpa.repository.CountryEntityRepository;
import com.demis27.countries.service.CountryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaCountryAdapter extends JpaResourceAdapter<Country, CountryEntity, Integer> implements CountryPort {

    public Long countCountries() {
        return repository.count();
    }

    public Optional<Country> getCountry(Integer countryCode) {
        return repository.findById(countryCode).map(mapper::toDomain);
    }

    public List<Country> getAllCountriesByRegion(Integer regionCode) {
        return ((CountryEntityRepository)repository).findCountryByRegionCode(regionCode).stream().map(mapper::toDomain).toList();
    }

    public List<Country> getAllCountriesBySubRegion(Integer subRegionCode) {
        return ((CountryEntityRepository)repository).findCountryBySubRegionCode(subRegionCode).stream().map(mapper::toDomain).toList();
    }
}
