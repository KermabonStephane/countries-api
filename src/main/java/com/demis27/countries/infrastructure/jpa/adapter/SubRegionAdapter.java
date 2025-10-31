package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.countries.domain.SubRegion;
import com.demis27.countries.infrastructure.jpa.mapper.SubRegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.SubRegionEntityRepository;
import com.demis27.countries.service.SubRegionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubRegionAdapter implements SubRegionPort {

    private final SubRegionEntityRepository repository;
    private final SubRegionEntityMapper mapper;

    @Override
    public List<SubRegion> getAllSubRegions(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Long countSubRegions() {
        return repository.count();
    }

    @Override
    public Optional<SubRegion> getSubRegion(Integer subRegionCode) {
        return repository.findById(subRegionCode).map(mapper::toDomain);
    }
}
