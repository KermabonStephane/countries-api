package com.demis27.countries.service;

import com.demis27.commons.restful.spring.model.APIResourcesRequest;
import com.demis27.commons.restful.spring.service.ResourceService;
import com.demis27.countries.domain.SubRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubRegionService extends ResourceService<SubRegion> {

    public List<SubRegion> getAllSubRegions(APIResourcesRequest request) {
        return support.getAllResources(request);
    }

    public Long countSubRegions() {
        return ((SubRegionPort)support).countSubRegions();
    }

    public Optional<SubRegion> getSubRegion(Integer subRegionCode) {
        return ((SubRegionPort)support).getSubRegion(subRegionCode);
    }

}
