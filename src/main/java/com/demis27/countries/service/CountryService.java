package com.demis27.countries.service;

import com.demis27.commons.restful.spring.model.APIResourcesRequest;
import com.demis27.commons.restful.spring.service.ResourceService;
import com.demis27.countries.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService extends ResourceService<Country> {

    public List<Country> getAllCountries(APIResourcesRequest request) {
        return support.getAllResources(request);
    }

    public Long countCountries() {
        return ((CountryPort)support).countCountries();
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
