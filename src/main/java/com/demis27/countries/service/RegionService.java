package com.demis27.countries.service;

import com.demis27.countries.domain.Region;
import com.demis27.countries.infrastructure.jpa.mapper.RegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.RegionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionEntityRepository repository;
    private final RegionEntityMapper mapper;

    public List<Region> getAllRegions(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::toDomain).toList();
    }

    public Long countRegions() {
        return repository.count();
    }

    public Optional<Region> getRegion(Integer regionCode) {
        return repository.findById(regionCode).map(mapper::toDomain);
    }
}
