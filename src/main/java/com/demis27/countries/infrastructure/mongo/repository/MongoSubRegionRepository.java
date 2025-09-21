package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.infrastructure.mongo.entity.SubRegionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoSubRegionRepository extends ReactiveMongoRepository<SubRegionEntity, String> {

    Flux<SubRegionEntity> findByRegion(String region);

    Mono<Boolean> existsByCode(Integer code);

    Mono<SubRegionEntity> findByCode(Integer code);
}
