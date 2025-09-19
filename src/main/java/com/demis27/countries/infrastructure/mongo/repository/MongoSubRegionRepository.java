package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.infrastructure.mongo.entity.SubRegionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoSubRegionRepository extends ReactiveMongoRepository<SubRegionEntity, String> {
    Mono<SubRegionEntity> findByName(String name);

    Flux<SubRegionEntity> findByRegion(String region);

    Mono<Boolean> existsByName(String name);
}
