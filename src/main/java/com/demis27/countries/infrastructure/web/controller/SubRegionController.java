package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.business.service.SubRegionService;
import com.demis27.countries.infrastructure.web.dto.SubRegionDto;
import com.demis27.countries.infrastructure.web.mapper.SubRegionDtoMapper;
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
@RequestMapping("/api/v1/subregions")
@RequiredArgsConstructor
public class SubRegionController {

    private final SubRegionService service;
    private final SubRegionDtoMapper mapper;

    @GetMapping
    public Flux<SubRegionDto> getAllSubRegions() {
        return service.getAllSubRegions().map(mapper::toDto);
    }

    @GetMapping("/{code}")
    public Mono<SubRegionDto> getSubRegionById(@PathVariable Integer code) {
        return service.getSubRegionByCode(code).map(mapper::toDto);
    }

    @PostMapping
    public Mono<SubRegionDto> createSubRegion(@RequestBody SubRegionDto subRegion) {
        return service.createSubRegion(mapper.toDomain(subRegion)).map(mapper::toDto);
    }

    @PutMapping("/{code}")
    public Mono<SubRegionDto> updateSubRegion(@PathVariable Integer code, @RequestBody SubRegionDto subRegion) {
        return service.updateSubRegion(code, mapper.toDomain(subRegion)).map(mapper::toDto);
    }

    @DeleteMapping("/{code}")
    public Mono<Void> deleteSubRegion(@PathVariable Integer code) {
        return service.deleteSubRegion(code);
    }
}
