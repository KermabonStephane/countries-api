package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.spring.infrastructure.jpa.JPAResourceAdapter;
import com.demis27.countries.domain.Region;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import com.demis27.countries.infrastructure.jpa.mapper.RegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.RegionEntityRepository;
import com.demis27.countries.service.RegionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JPARegionAdapter extends JPAResourceAdapter<Region, RegionEntity, Integer> implements RegionPort {

    private final RegionEntityRepository repository;
    private final RegionEntityMapper mapper;

    @Override
    public Long countRegions() {
        return repository.count();
    }

    @Override
    public Optional<Region> getRegion(Integer regionCode) {
        return repository.findById(regionCode).map(mapper::toDomain);
    }
}
