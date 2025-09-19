package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.business.repository.RegionRepository;
import com.demis27.countries.domain.model.Region;
import com.demis27.countries.infrastructure.mongo.mapper.RegionEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {

    private final MongoRegionRepository mongoRegionRepository;
    private final RegionEntityMapper mapper;


    @Override
    public Flux<Region> findAll() {
        return mongoRegionRepository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<Region> findById(String id) {
        return mongoRegionRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<Region> findByName(String name) {
        return mongoRegionRepository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public Mono<Region> save(Region region) {
        return mongoRegionRepository.save(mapper.toEntity(region)).map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return mongoRegionRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsByName(String name) {
        return mongoRegionRepository.existsByName(name);
    }

    @Override
    public Mono<Region> findByCode(Integer code) {
        return mongoRegionRepository.findByCode(code).map(mapper::toDomain);
    }
}
