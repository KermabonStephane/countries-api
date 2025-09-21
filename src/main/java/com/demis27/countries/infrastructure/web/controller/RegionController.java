package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.business.service.RegionService;
import com.demis27.countries.infrastructure.web.dto.RegionDto;
import com.demis27.countries.infrastructure.web.mapper.RegionDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService service;
    private final RegionDtoMapper mapper;

    @GetMapping
    public Flux<RegionDto> getAllRegions() {
        return service.getAllRegions().map(mapper::toDto);
    }

    @GetMapping("/{code}")
    public Mono<RegionDto> getRegionById(@PathVariable Integer code) {
        return service.getRegionByCode(code).map(mapper::toDto);
    }

    @PostMapping
    public Mono<RegionDto> createRegion(@RequestBody RegionDto region) {
        return service.createRegion(mapper.toDomain(region)).map(mapper::toDto);
    }

    @PutMapping("/{code}")
    public Mono<RegionDto> updateRegion(@PathVariable Integer code, @RequestBody RegionDto region) {
        return service.updateRegion(code, mapper.toDomain(region)).map(mapper::toDto);
    }

    @DeleteMapping("/{code}")
    public Mono<Void> deleteRegion(@PathVariable Integer code) {
        return service.deleteRegion(code);
    }
}
