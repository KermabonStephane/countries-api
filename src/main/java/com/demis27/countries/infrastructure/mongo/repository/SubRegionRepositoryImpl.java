package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.business.repository.SubRegionRepository;
import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.mongo.mapper.SubRegionEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SubRegionRepositoryImpl implements SubRegionRepository {

    private final MongoSubRegionRepository mongoSubRegionRepository;
    private final SubRegionEntityMapper mapper;


    @Override
    public Flux<SubRegion> findAll() {
        return mongoSubRegionRepository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<SubRegion> findById(String id) {
        return mongoSubRegionRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<SubRegion> findByName(String name) {
        return mongoSubRegionRepository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public Flux<SubRegion> findByRegion(String region) {
        return mongoSubRegionRepository.findByRegion(region).map(mapper::toDomain);
    }

    @Override
    public Mono<SubRegion> save(SubRegion subRegion) {
        return mongoSubRegionRepository.save(mapper.toEntity(subRegion)).map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return mongoSubRegionRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsByName(String name) {
        return mongoSubRegionRepository.existsByName(name);
    }
}
