package com.demis27.countries.service;

import com.demis27.countries.domain.Country;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CountryPort {

    List<Country> getAllCountries(Pageable pageable);

    Long countCountries();

    Optional<Country> getCountry(Integer countryCode);

    List<Country> getAllCountriesByRegion(Integer regionCode);

    List<Country> getAllCountriesBySubRegion(Integer subRegionCode);
}
