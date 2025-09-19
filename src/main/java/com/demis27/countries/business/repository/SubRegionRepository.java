package com.demis27.countries.business.repository;

import com.demis27.countries.domain.model.SubRegion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubRegionRepository {
    Flux<SubRegion> findAll();

    Mono<SubRegion> findById(String id);

    Mono<SubRegion> findByName(String name);

    Flux<SubRegion> findByRegion(String region);

    Mono<SubRegion> save(SubRegion subRegion);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsByName(String name);
}
