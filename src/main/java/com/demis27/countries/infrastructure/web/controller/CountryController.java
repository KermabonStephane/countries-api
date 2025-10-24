package com.demis27.countries.infrastructure.web.controller;

import com.demis27.commons.restful.HeaderPageable;
import com.demis27.commons.restful.spring.SpringSupport;
import com.demis27.countries.business.service.CountryService;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.mapper.CountryDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/countries", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CountryController {

    private final CountryService service;
    private final CountryDtoMapper countryMapper;
    private final SpringSupport springSupport;

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries(@RequestHeader(name = "Range", required = false) String rangeHeader, @RequestParam(name = "sort", required = false) String sortsQueryParam) {
        PageRequest pageable = springSupport.parseFromRest(rangeHeader, sortsQueryParam);
        HeaderPageable resultRange = springSupport.extractHeaderPageable(pageable, "countries");
        resultRange = HeaderPageable.toBuilder(resultRange).total(service.countCountries()).build();
        return ResponseEntity
                .ok()
                .header(HeaderPageable.CONTENT_RANGE_HEADER_NAME, resultRange.toContentRangeHeader(false))
                .header("link", resultRange.toLinkHeaders("/api/v1/countries").toString())
                .body(service.getAllCountries(pageable)
                        .stream()
                        .map(countryMapper::toDto)
                        .toList());
    }

}
