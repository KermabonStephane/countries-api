package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.dto.ErrorDto;
import com.demis27.countries.infrastructure.web.dto.RegionDto;
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

@Tag(name = "Regions", description = "API for retrieving region information.")
public interface RegionApi {

    @Operation(
            summary = "List all regions",
            description = "Retrieves a paginated and sortable list of all regions.",
            parameters = {
                    @Parameter(name = "Range", in = ParameterIn.HEADER, description = "Pagination range, e.g., 'regions=0-4'"),
                    @Parameter(name = "sort", in = ParameterIn.QUERY, description = "Sort order, e.g., 'name:asc'")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A paginated list of regions.",
                            headers = {
                                    @io.swagger.v3.oas.annotations.headers.Header(name = "Content-Range", description = "Pagination details, e.g., 'regions 0-4/5'"),
                                    @io.swagger.v3.oas.annotations.headers.Header(name = "Link", description = "Links for pagination (first, next, prev, last)")
                            }
                    )
            }
    )
    @GetMapping
    ResponseEntity<List<RegionDto>> getAllRegions(@RequestHeader(name = "Range", required = false) String rangeHeader, @RequestParam(name = "sort", required = false) String sortsQueryParam);

    @Operation(
            summary = "Get a region by its code",
            description = "Retrieves a single region by its unique numeric code.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Region found."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Region not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/{regionCode}")
    ResponseEntity<RegionDto> getRegion(
            @Parameter(description = "The numeric code of the region.", example = "150") @PathVariable("regionCode") Integer regionCode
    );

    @Operation(
            summary = "Get countries by region",
            description = "Retrieves a list of all countries belonging to a specific region.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of countries in the region."),
                    @ApiResponse(responseCode = "404", description = "Region not found (returns an empty list of countries).", content = @Content)
            }
    )
    @GetMapping("/{regionCode}/countries")
    ResponseEntity<List<CountryDto>> getCountriesByRegion(
            @Parameter(description = "The numeric code of the region.", example = "150") @PathVariable("regionCode") Integer regionCode
    );
}