package com.demis27.countries.service;

import com.demis27.commons.restful.spring.service.ResourcePort;
import com.demis27.countries.domain.SubRegion;

import java.util.Optional;

public interface SubRegionPort extends ResourcePort<SubRegion> {

    Long countSubRegions();

    Optional<SubRegion> getSubRegion(Integer subRegionCode);

}
