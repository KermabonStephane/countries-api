package com.demis27.countries.service;

import com.demis27.countries.domain.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryPort countryPort;

    public List<Country> getAllCountries(Pageable pageable) {
        return countryPort.getAllCountries(pageable);
    }

    public Long countCountries() {
        return countryPort.countCountries();
    }

    public Optional<Country> getCountry(Integer countryCode) {
        return countryPort.getCountry(countryCode);
    }

    public List<Country> getAllCountriesByRegion(Integer regionCode) {
        return countryPort.getAllCountriesByRegion(regionCode);
    }

    public List<Country> getAllCountriesBySubRegion(Integer subRegionCode) {
        return countryPort.getAllCountriesBySubRegion(subRegionCode);
    }
}
