package com.demis27.countries.business.service;

import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.jpa.mapper.SubRegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.SubRegionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubRegionService {

    private final SubRegionEntityRepository subRegionRepository;
    private final SubRegionEntityMapper subRegionMapper;

    public List<SubRegion> getAllSubRegions(Pageable pageable) {
        return subRegionRepository.findAll(pageable).stream().map(subRegionMapper::toDomain).toList();
    }

    public Long countSubRegions() {
        return subRegionRepository.count();
    }
}
