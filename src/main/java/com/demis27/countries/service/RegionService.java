package com.demis27.countries.service;

import com.demis27.commons.restful.QueryParamFilter;
import com.demis27.countries.domain.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionPort regionPort;

    public List<Region> getAllRegions(Pageable pageable) {
        return regionPort.getAllRegions(pageable);
    }

    public Long countRegions() {
        return regionPort.countRegions();
    }

    public Optional<Region> getRegion(Integer regionCode) {
        return regionPort.getRegion(regionCode);
    }

    public List<Region> getRegions(Pageable pageable, List<QueryParamFilter> filters) {
        return regionPort.getRegions(pageable, filters);
    }
}
