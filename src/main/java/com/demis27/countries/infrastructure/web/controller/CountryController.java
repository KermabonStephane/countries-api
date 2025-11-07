package com.demis27.countries.infrastructure.web.controller;

import com.demis27.commons.restful.spring.infrastructure.web.ResourceController;
import com.demis27.commons.restful.spring.model.APIResourcesRequest;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.exception.ResourceNotFoundException;
import com.demis27.countries.infrastructure.web.mapper.CountryDtoMapper;
import com.demis27.countries.service.CountryService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/api/v1/countries", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CountryController extends ResourceController<CountryDto> implements CountryApi {

    private final CountryService service;
    private final CountryDtoMapper mapper;

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries(
            @RequestHeader(name = "Range", required = false) String rangeHeader,
            @RequestParam(name = "sort", required = false) String sortsQueryParam,
            @RequestParam(name = "filter", required = false) String filterQueryParam) {
        APIResourcesRequest request = new APIResourcesRequest(
                "countries",
                "/api/v1/countries",
                rangeHeader,
                sortsQueryParam,
                filterQueryParam);
        return getAll(
                request,
                resourceRequest -> service.getAllResources(resourceRequest).stream().map(mapper::toDto).toList(),
                service::countResources);
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<CountryDto> getCountry(@PathVariable("countryCode") Integer countryCode) {
        return ResponseEntity.ok(
                service
                .getCountry(countryCode)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Country with code %d not found".formatted(countryCode))));
    }
}
