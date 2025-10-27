package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.dto.ErrorDto;
import com.demis27.countries.infrastructure.web.dto.SubRegionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Sub-Regions", description = "API for retrieving sub-region information.")
public interface SubRegionApi {

    @Operation(
            summary = "List all sub-regions",
            description = "Retrieves a paginated and sortable list of all sub-regions.",
            parameters = {
                    @Parameter(name = "Range", in = ParameterIn.HEADER, description = "Pagination range, e.g., 'sub-regions=0-9'"),
                    @Parameter(name = "sort", in = ParameterIn.QUERY, description = "Sort order, e.g., 'name:asc'")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A paginated list of sub-regions.",
                            headers = {
                                    @io.swagger.v3.oas.annotations.headers.Header(name = "Content-Range", description = "Pagination details, e.g., 'sub-regions 0-9/23'"),
                                    @io.swagger.v3.oas.annotations.headers.Header(name = "Link", description = "Links for pagination (first, next, prev, last)")
                            }
                    )
            }
    )
    @GetMapping
    ResponseEntity<List<SubRegionDto>> getAllSubRegions(@RequestHeader(name = "Range", required = false) String rangeHeader, @RequestParam(name = "sort", required = false) String sortsQueryParam);

    @Operation(
            summary = "Get a sub-region by its code",
            description = "Retrieves a single sub-region by its unique numeric code.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sub-region found."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Sub-region not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/{subRegionCode}")
    ResponseEntity<SubRegionDto> getSubRegion(
            @Parameter(description = "The numeric code of the sub-region.", example = "155") @PathVariable("subRegionCode") Integer subRegionCode
    );

    @Operation(
            summary = "Get countries by sub-region",
            description = "Retrieves a list of all countries belonging to a specific sub-region.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of countries in the sub-region."),
                    @ApiResponse(responseCode = "404", description = "Sub-region not found (returns an empty list of countries).", content = @Content)
            }
    )
    @GetMapping("/{subRegionCode}/countries")
    ResponseEntity<List<CountryDto>> getCountriesBySubRegion(
            @Parameter(description = "The numeric code of the sub-region.", example = "155") @PathVariable("subRegionCode") Integer subRegionCode
    );
}