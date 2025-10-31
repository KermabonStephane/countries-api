package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.spring.infrastructure.jpa.JPAResourceAdapter;
import com.demis27.countries.domain.SubRegion;
import com.demis27.countries.infrastructure.jpa.entity.SubRegionEntity;
import com.demis27.countries.infrastructure.jpa.mapper.SubRegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.SubRegionEntityRepository;
import com.demis27.countries.service.SubRegionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JPASubRegionAdapter extends JPAResourceAdapter<SubRegion, SubRegionEntity, Integer> implements SubRegionPort {

    private final SubRegionEntityRepository repository;
    private final SubRegionEntityMapper mapper;

    @Override
    public Long countSubRegions() {
        return repository.count();
    }

    @Override
    public Optional<SubRegion> getSubRegion(Integer subRegionCode) {
        return repository.findById(subRegionCode).map(mapper::toDomain);
    }
}
