package com.demis27.countries.service;

import com.demis27.commons.restful.spring.model.APIResourcesRequest;
import com.demis27.commons.restful.spring.service.ResourceService;
import com.demis27.countries.domain.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService extends ResourceService<Region> {

    public List<Region> getAllRegions(APIResourcesRequest request) {
        return support.getAllResources(request);
    }

    public Long countRegions() {
        return ((RegionPort)support).countRegions();
    }

    public Optional<Region> getRegion(Integer regionCode) {
        return ((RegionPort)support).getRegion(regionCode);
    }
}
