package com.demis27.countries.infrastructure.web.controller;

import com.demis27.countries.infrastructure.web.dto.CountryDto;
import com.demis27.countries.infrastructure.web.dto.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
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

@Tag(name = "Countries", description = "API for retrieving country information.")
public interface CountryApi {

    @Operation(
            summary = "List all countries",
            description = "Retrieves a paginated and sortable list of all countries.",
            parameters = {
                    @Parameter(name = "Range", in = ParameterIn.HEADER,
                            description = "Pagination range, e.g., 'countries=0-9'"),
                    @Parameter(name = "sort", in = ParameterIn.QUERY,
                            description = "Sort order, e.g., 'name:asc'"),
                    @Parameter(name = "filter", in = ParameterIn.QUERY,
                            description = "Filters, e.g., 'firstname eq John, lastname eq Byrne'")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A paginated list of countries.",
                            headers = {
                                    @Header(name = "Content-Range",
                                            description = "Pagination details, e.g., 'countries 0-9/250'"),
                                    @Header(name = "Link",
                                            description = "Links for pagination (first, next, prev, last)")
                            }
                    )
            }
    )
    @GetMapping
    ResponseEntity<List<CountryDto>> getAllCountries(
            @RequestHeader(name = "Range", required = false) String rangeHeader,
            @RequestParam(name = "sort", required = false) String sortsQueryParam,
            @RequestParam(name = "filter", required = false) String filterQueryParam);

    @Operation(
            summary = "Get a country by its code",
            description = "Retrieves a single country by its unique numeric code.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Country found."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Country not found.",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorDto.class))
                    )
            }
    )
    @GetMapping("/{countryCode}")
    ResponseEntity<CountryDto> getCountry(
            @Parameter(description = "The numeric code of the country.", example = "250")
            @PathVariable("countryCode")
            Integer countryCode
    );
}