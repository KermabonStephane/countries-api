package com.demis27.countries.business.service;

import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.jpa.mapper.SubRegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.SubRegionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubRegionService {

    private final SubRegionEntityRepository repository;
    private final SubRegionEntityMapper mapper;

    public List<SubRegion> getAllSubRegions(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::toDomain).toList();
    }

    public Long countSubRegions() {
        return repository.count();
    }

    public Optional<SubRegion> getSubRegion(Integer subRegionCode) {
        return repository.findById(subRegionCode).map(mapper::toDomain);
    }
}
