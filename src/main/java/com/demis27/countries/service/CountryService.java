package com.demis27.countries.service;

import com.demis27.commons.restful.spring.service.ResourcePort;
import com.demis27.commons.restful.spring.service.ResourceService;
import com.demis27.countries.domain.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService extends ResourceService<Country> {

    protected CountryService(ResourcePort<Country> support) {
        super(support);
    }

    public Optional<Country> getCountry(Integer countryCode) {
        return ((CountryPort)support).getCountry(countryCode);
    }

    public List<Country> getAllCountriesByRegion(Integer regionCode) {
        return ((CountryPort)support).getAllCountriesByRegion(regionCode);
    }

    public List<Country> getAllCountriesBySubRegion(Integer subRegionCode) {
        return ((CountryPort)support).getAllCountriesBySubRegion(subRegionCode);
    }
}
