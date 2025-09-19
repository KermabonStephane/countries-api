package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.infrastructure.mongo.entity.CountryEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoCountryRepository extends ReactiveMongoRepository<CountryEntity, String> {
    Mono<CountryEntity> findByAlpha2Code(String alpha2Code);

    Mono<CountryEntity> findByAlpha3Code(String alpha3Code);

    Flux<CountryEntity> findByRegion(String region);

    Flux<CountryEntity> findBySubregion(String subregion);

    Mono<Boolean> existsByAlpha2Code(String alpha2Code);

    Mono<Boolean> existsByAlpha3Code(String alpha3Code);
}
