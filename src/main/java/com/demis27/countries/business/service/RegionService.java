package com.demis27.countries.business.service;

import com.demis27.countries.business.repository.RegionRepository;
import com.demis27.countries.domain.model.Region;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Flux<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Mono<Region> getRegionById(String id) {
        return regionRepository.findById(id);
    }

    public Mono<Region> getRegionByName(String name) {
        return regionRepository.findByName(name);
    }

    public Mono<Region> createRegion(Region region) {
        return regionRepository.existsByName(region.getName())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("Region with name " + region.getName() + " already exists"));
                    }
                    return regionRepository.save(region);
                });
    }

    public Mono<Region> updateRegion(Integer code, Region region) {
        return regionRepository.findByCode(code)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Region not found")))
                .flatMap(existingRegion -> {
                    region.setId(existingRegion.getId());
                    return regionRepository.save(region);
                });
    }

    public Mono<Void> deleteRegion(Integer code) {
        return regionRepository.findByCode(code)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Region not found")))
                .flatMap(subRegion -> regionRepository.deleteById(subRegion.getId()));
    }

    public Mono<Region> getRegionByCode(Integer code) {
        return regionRepository.findByCode(code);
    }
}
