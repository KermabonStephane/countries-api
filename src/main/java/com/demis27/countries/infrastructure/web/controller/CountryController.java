package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.business.service.CountryService;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.mapper.CountryDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService service;
    private final CountryDtoMapper mapper;

    @GetMapping
    public Flux<CountryDto> getAllCountries() {
        return service.getAllCountries().map(mapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<CountryDto> getCountryById(@PathVariable String id) {
        return service.getCountryById(id).map(mapper::toDto);
    }

    @GetMapping("/alpha2/{alpha2Code}")
    public Mono<CountryDto> getCountryByAlpha2Code(@PathVariable String alpha2Code) {
        return service.getCountryByAlpha2Code(alpha2Code).map(mapper::toDto);
    }

    @GetMapping("/alpha3/{alpha3Code}")
    public Mono<CountryDto> getCountryByAlpha3Code(@PathVariable String alpha3Code) {
        return service.getCountryByAlpha3Code(alpha3Code).map(mapper::toDto);
    }

    @GetMapping("/region/{region}")
    public Flux<CountryDto> getCountriesByRegion(@PathVariable String region) {
        return service.getCountriesByRegion(region).map(mapper::toDto);
    }

    @GetMapping("/subregion/{subregion}")
    public Flux<CountryDto> getCountriesBySubregion(@PathVariable String subregion) {
        return service.getCountriesBySubregion(subregion).map(mapper::toDto);
    }

    @PostMapping
    public Mono<CountryDto> createCountry(@RequestBody CountryDto country) {
        return service.createCountry(mapper.toDomain(country)).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    public Mono<CountryDto> updateCountry(@PathVariable String id, @RequestBody CountryDto country) {
        return service.updateCountry(id, mapper.toDomain(country)).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCountry(@PathVariable String id) {
        return service.deleteCountry(id);
    }
}
