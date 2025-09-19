package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.business.repository.CountryRepository;
import com.demis27.countries.domain.model.Country;
import com.demis27.countries.infrastructure.mongo.mapper.CountryEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CountryRepositoryImpl implements CountryRepository {

    private final MongoCountryRepository mongoCountryRepository;
    private final CountryEntityMapper mapper;

    @Override
    public Flux<Country> findAll() {
        return mongoCountryRepository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<Country> findById(String id) {
        return mongoCountryRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<Country> findByAlpha2Code(String alpha2Code) {
        return mongoCountryRepository.findByAlpha2Code(alpha2Code).map(mapper::toDomain);
    }

    @Override
    public Mono<Country> findByAlpha3Code(String alpha3Code) {
        return mongoCountryRepository.findByAlpha3Code(alpha3Code).map(mapper::toDomain);
    }

    @Override
    public Flux<Country> findByRegion(String region) {
        return mongoCountryRepository.findByRegion(region).map(mapper::toDomain);
    }

    @Override
    public Flux<Country> findBySubregion(String subregion) {
        return mongoCountryRepository.findBySubregion(subregion).map(mapper::toDomain);
    }

    @Override
    public Mono<Country> save(Country country) {
        return mongoCountryRepository.save(mapper.toEntity(country)).map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return mongoCountryRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsByAlpha2Code(String alpha2Code) {
        return mongoCountryRepository.existsByAlpha2Code(alpha2Code);
    }

    @Override
    public Mono<Boolean> existsByAlpha3Code(String alpha3Code) {
        return mongoCountryRepository.existsByAlpha3Code(alpha3Code);
    }
}
