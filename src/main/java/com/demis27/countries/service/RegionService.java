package com.demis27.countries.service;

import com.demis27.commons.restful.spring.service.ResourcePort;
import com.demis27.commons.restful.spring.service.ResourceService;
import com.demis27.countries.domain.Region;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionService extends ResourceService<Region> {

    protected RegionService(ResourcePort<Region> support) {
        super(support);
    }

    public Optional<Region> getRegion(Integer regionCode) {
        return ((RegionPort)support).getRegion(regionCode);
    }
}
