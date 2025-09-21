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

    public Mono<SubRegion> createSubRegion(SubRegion subRegion) {
        return subRegionRepository.existsByCode(subRegion.getCode())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("SubRegion with code " + subRegion.getCode() + " already exists"));
                    }
                    return subRegionRepository.save(subRegion);
                });
    }

    public Mono<SubRegion> updateSubRegion(Integer code, SubRegion subRegion) {
        return subRegionRepository.findByCode(code)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("SubRegion not found")))
                .flatMap(existingSubRegion -> {
                    subRegion.setId(existingSubRegion.getId());
                    return subRegionRepository.save(subRegion);
                });
    }

    public Mono<Void> deleteSubRegion(Integer code) {
        return subRegionRepository.findByCode(code)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("SubRegion not found")))
                .flatMap(subRegion -> subRegionRepository.deleteById(subRegion.getId()));
    }

    public Mono<SubRegion> getSubRegionByCode(Integer code) {
        return subRegionRepository.findByCode(code);
    }
}
