package com.demis27.countries.service;

import com.demis27.commons.restful.spring.service.ResourcePort;
import com.demis27.commons.restful.spring.service.ResourceService;
import com.demis27.countries.domain.SubRegion;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubRegionService extends ResourceService<SubRegion> {

    protected SubRegionService(ResourcePort<SubRegion> support) {
        super(support);
    }

    public Optional<SubRegion> getSubRegion(Integer subRegionCode) {
        return ((SubRegionPort)support).getSubRegion(subRegionCode);
    }

}
