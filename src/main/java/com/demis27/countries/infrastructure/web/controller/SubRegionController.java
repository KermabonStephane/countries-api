package com.demis27.countries.infrastructure.web.controller;

import com.demis27.commons.restful.HeaderPageable;
import com.demis27.commons.restful.spring.SpringSupport;
import com.demis27.countries.service.CountryService;
import com.demis27.countries.service.SubRegionService;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.dto.SubRegionDto;
import com.demis27.countries.infrastructure.web.exception.ResourceNotFoundException;
import com.demis27.countries.infrastructure.web.mapper.CountryDtoMapper;
import com.demis27.countries.infrastructure.web.mapper.SubRegionDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/sub-regions", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SubRegionController implements SubRegionApi {

    private final SubRegionService service;
    private final SpringSupport springSupport;
    private final SubRegionDtoMapper mapper;
    private final CountryService countryService;
    private final CountryDtoMapper countryMapper;


    @GetMapping
    public ResponseEntity<List<SubRegionDto>> getAllSubRegions(@RequestHeader(name = "Range", required = false) String rangeHeader, @RequestParam(name = "sort", required = false) String sortsQueryParam) {
        PageRequest pageable = springSupport.parseFromRest(rangeHeader, sortsQueryParam);
        HeaderPageable resultRange = springSupport.extractHeaderPageable(pageable, "sub-regions");
        resultRange = HeaderPageable.toBuilder(resultRange).total(service.countSubRegions()).build();
        return ResponseEntity
                .ok()
                .header(HeaderPageable.CONTENT_RANGE_HEADER_NAME, resultRange.toContentRangeHeader(false))
                .header("link", resultRange.toLinkHeaders("/api/v1/sub-regions").toString())
                .body(service.getAllSubRegions(pageable)
                        .stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @GetMapping("/{subRegionCode}")
    public ResponseEntity<SubRegionDto> getSubRegion(@PathVariable("subRegionCode") Integer subRegionCode) {
        return ResponseEntity.ok(service.getSubRegion(subRegionCode).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Sub-Region with code %d not found".formatted(subRegionCode))));
    }

    @GetMapping("/{subRegionCode}/countries")
    public ResponseEntity<List<CountryDto>> getCountriesBySubRegion(@PathVariable("subRegionCode") Integer subRegionCode) {
        return ResponseEntity.ok(countryService.getAllCountriesBySubRegion(subRegionCode).stream().map(countryMapper::toDto).toList());
    }

}
