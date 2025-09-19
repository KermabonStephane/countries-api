package com.demis27.countries.business.service;

import com.demis27.countries.business.repository.CountryRepository;
import com.demis27.countries.domain.model.Country;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Flux<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Mono<Country> getCountryById(String id) {
        return countryRepository.findById(id);
    }

    public Mono<Country> getCountryByAlpha2Code(String alpha2Code) {
        return countryRepository.findByAlpha2Code(alpha2Code);
    }

    public Mono<Country> getCountryByAlpha3Code(String alpha3Code) {
        return countryRepository.findByAlpha3Code(alpha3Code);
    }

    public Flux<Country> getCountriesByRegion(String region) {
        return countryRepository.findByRegion(region);
    }

    public Flux<Country> getCountriesBySubregion(String subregion) {
        return countryRepository.findBySubregion(subregion);
    }

    public Mono<Country> createCountry(Country country) {
        return countryRepository.existsByAlpha2Code(country.getAlpha2Code())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("Country with alpha2 code " + country.getAlpha2Code() + " already exists"));
                    }
                    return countryRepository.save(country);
                });
    }

    public Mono<Country> updateCountry(String id, Country country) {
        return countryRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Country not found")))
                .flatMap(existingCountry -> {
                    country.setId(id);
                    return countryRepository.save(country);
                });
    }

    public Mono<Void> deleteCountry(String id) {
        return countryRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Country not found")))
                .flatMap(country -> countryRepository.deleteById(id));
    }
}
