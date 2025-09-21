package com.demis27.countries.infrastructure.mongo.repository;

import com.demis27.countries.business.repository.SubRegionRepository;
import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.mongo.entity.SubRegionEntity;
import com.demis27.countries.infrastructure.mongo.mapper.SubRegionEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public Mono<SubRegion> save(SubRegion subRegion) {
        return mongoSubRegionRepository.save(mapper.toEntity(subRegion)).map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return mongoSubRegionRepository.deleteById(id);
    }

    @Override
    public Mono<Boolean> existsByCode(Integer code) {
        return mongoSubRegionRepository.existsByCode(code);
    }

    @Override
    public Mono<SubRegion> findByCode(Integer code) {
        return mongoSubRegionRepository.findByCode(code).map(mapper::toDomain);
    }

    @Override
    public Flux<SubRegion> saveAll(Iterable<SubRegion> subRegions) {
        Iterable<SubRegionEntity> subRegionEntities = StreamSupport.stream(subRegions.spliterator(), false)
                .map(mapper::toEntity)
                .collect(Collectors.toList());
        return mongoSubRegionRepository.saveAll(subRegionEntities)
                .map(mapper::toDomain);
    }
}
