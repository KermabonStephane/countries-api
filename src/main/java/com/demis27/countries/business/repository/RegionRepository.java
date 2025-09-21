package com.demis27.countries.business.repository;

import com.demis27.countries.domain.model.Region;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegionRepository {
    Flux<Region> findAll();

    Mono<Region> findById(String id);

    Mono<Region> findByName(String name);

    Mono<Region> save(Region region);

    Mono<Void> deleteById(String id);

    Mono<Boolean> existsByName(String name);

    Mono<Region> findByCode(Integer code);

    Flux<Region> saveAll(Iterable<Region> regions);
}
