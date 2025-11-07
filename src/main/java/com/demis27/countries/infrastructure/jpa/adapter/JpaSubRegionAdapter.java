package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.spring.infrastructure.jpa.EntityMapper;
import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceAdapter;
import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceRepository;
import com.demis27.countries.domain.SubRegion;
import com.demis27.countries.infrastructure.jpa.entity.SubRegionEntity;
import com.demis27.countries.service.SubRegionPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaSubRegionAdapter extends JpaResourceAdapter<SubRegion, SubRegionEntity, Integer> implements SubRegionPort {

    protected JpaSubRegionAdapter(JpaResourceRepository<SubRegionEntity, Integer> repository, EntityMapper<SubRegionEntity, SubRegion> mapper) {
        super(repository, mapper);
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
