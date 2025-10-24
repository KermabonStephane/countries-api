package com.demis27.countries.business.service;

import com.demis27.countries.domain.model.Region;
import com.demis27.countries.infrastructure.jpa.mapper.RegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.RegionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionEntityRepository regionsRepository;
    private final RegionEntityMapper regionsMapper;

    public List<Region> getAllRegions(Pageable pageable) {
        return regionsRepository.findAll(pageable).stream().map(regionsMapper::toDomain).toList();
    }

    public Long countRegions() {
        return regionsRepository.count();
    }
}
