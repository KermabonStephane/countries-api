package com.demis27.countries.service;

import com.demis27.commons.restful.QueryParamFilter;
import com.demis27.countries.domain.Region;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RegionPort {

    List<Region> getAllRegions(Pageable pageable);

    Long countRegions();

    Optional<Region> getRegion(Integer regionCode);

    List<Region> getRegions(Pageable pageable, List<QueryParamFilter> filters);
}
