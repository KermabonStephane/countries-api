package com.demis27.countries.business.service;

import com.demis27.countries.business.repository.SubRegionRepository;
import com.demis27.countries.domain.model.SubRegion;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubRegionService {

    private final SubRegionRepository subRegionRepository;

    public SubRegionService(SubRegionRepository subRegionRepository) {
        this.subRegionRepository = subRegionRepository;
    }

    public Flux<SubRegion> getAllSubRegions() {
        return subRegionRepository.findAll();
    }

    public Mono<SubRegion> getSubRegionById(String id) {
        return subRegionRepository.findById(id);
    }

    public Mono<SubRegion> getSubRegionByName(String name) {
        return subRegionRepository.findByName(name);
    }

    public Flux<SubRegion> getSubRegionsByRegion(String region) {
        return subRegionRepository.findByRegion(region);
    }

    public Mono<SubRegion> createSubRegion(SubRegion subRegion) {
        return subRegionRepository.existsByName(subRegion.getName())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("SubRegion with name " + subRegion.getName() + " already exists"));
                    }
                    return subRegionRepository.save(subRegion);
                });
    }

    public Mono<SubRegion> updateSubRegion(String id, SubRegion subRegion) {
        return subRegionRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("SubRegion not found")))
                .flatMap(existingSubRegion -> {
                    subRegion.setId(id);
                    return subRegionRepository.save(subRegion);
                });
    }

    public Mono<Void> deleteSubRegion(String id) {
        return subRegionRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("SubRegion not found")))
                .flatMap(subRegion -> subRegionRepository.deleteById(id));
    }
}
