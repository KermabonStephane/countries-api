package com.demis27.countries.service;

import com.demis27.countries.domain.SubRegion;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SubRegionPort {

    List<SubRegion> getAllSubRegions(Pageable pageable);

    Long countSubRegions();

    Optional<SubRegion> getSubRegion(Integer subRegionCode);

}
