package com.demis27.countries.service;

import com.demis27.commons.restful.spring.service.ResourcePort;
import com.demis27.countries.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryPort extends ResourcePort<Country> {

    Long countCountries();

    Optional<Country> getCountry(Integer countryCode);

    List<Country> getAllCountriesByRegion(Integer regionCode);

    List<Country> getAllCountriesBySubRegion(Integer subRegionCode);
}
