package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.infrastructure.mongo.entity.RegionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MongoRegionRepository extends ReactiveMongoRepository<RegionEntity, String> {
    Mono<RegionEntity> findByName(String name);

    Mono<Boolean> existsByName(String name);

    Mono<RegionEntity> findByCode(Integer code);

}
