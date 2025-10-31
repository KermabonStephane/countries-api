package com.demis27.countries.service;

import com.demis27.commons.restful.spring.service.ResourcePort;
import com.demis27.countries.domain.Region;

import java.util.Optional;

public interface RegionPort extends ResourcePort<Region> {

    Long countRegions();

    Optional<Region> getRegion(Integer regionCode);
}
