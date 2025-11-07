package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.spring.infrastructure.jpa.EntityMapper;
import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceAdapter;
import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceRepository;
import com.demis27.countries.domain.Region;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import com.demis27.countries.service.RegionPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaRegionAdapter extends JpaResourceAdapter<Region, RegionEntity, Integer> implements RegionPort {

    protected JpaRegionAdapter(JpaResourceRepository<RegionEntity, Integer> repository, EntityMapper<RegionEntity, Region> mapper) {
        super(repository, mapper);
    }

    @Override
    public Long countRegions() {
        return repository.count();
    }

    @Override
    public Optional<Region> getRegion(Integer regionCode) {
        return repository.findById(regionCode).map(mapper::toDomain);
    }
}
