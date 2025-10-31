package com.demis27.countries.service;

import com.demis27.countries.domain.SubRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubRegionService {

    private final SubRegionPort subRegionPort;

    public List<SubRegion> getAllSubRegions(Pageable pageable) {
        return subRegionPort.getAllSubRegions(pageable);
    }

    public Long countSubRegions() {
        return subRegionPort.countSubRegions();
    }

    public Optional<SubRegion> getSubRegion(Integer subRegionCode) {
        return subRegionPort.getSubRegion(subRegionCode);
    }
}
