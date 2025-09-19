package com.demis27.countries.business.repository;

import com.demis27.countries.domain.model.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryRepository {
    Flux<Country> findAll();

    Mono<Country> findById(String id);

    Mono<Country> findByAlpha2Code(String alpha2Code);

    Mono<Country> findByAlpha3Code(String alpha3Code);

    Flux<Country> findByRegion(String region);

    Flux<Country> findBySubregion(String subregion);

    Mono<Country> save(Country country);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsByAlpha2Code(String alpha2Code);

    Mono<Boolean> existsByAlpha3Code(String alpha3Code);
}
