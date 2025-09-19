package com.demis27.countries.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Country Data Transfer Object")
public class CountryDto {

    @Schema(description = "Unique identifier", example = "507f1f77bcf86cd799439011")
    private String id;

    @NotBlank(message = "Alpha2 code is mandatory")
    @Size(min = 2, max = 2, message = "Alpha2 code must be exactly 2 characters")
    @Schema(description = "ISO 3166-1 alpha-2 code", example = "FR", required = true)
    private String alpha2Code;

    @NotBlank(message = "Alpha3 code is mandatory")
    @Size(min = 3, max = 3, message = "Alpha3 code must be exactly 3 characters")
    @Schema(description = "ISO 3166-1 alpha-3 code", example = "FRA", required = true)
    private String alpha3Code;

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "Country name", example = "France", required = true)
    private String name;

    @Schema(description = "Native country name", example = "France")
    private String nativeName;

    @Schema(description = "ISO 3166-1 numeric code", example = "250")
    private String numericCode;

    @Schema(description = "Region", example = "Europe")
    private String region;

    @Schema(description = "Sub-region", example = "Western Europe")
    private String subregion;

    @Schema(description = "Population", example = "67391582")
    private Long population;

    @Schema(description = "Area in square kilometers", example = "551695.0")
    private Double area;

    @Schema(description = "Top level domains")
    private List<String> topLevelDomain;

    @Schema(description = "Currencies")
    private List<String> currencies;

    @Schema(description = "Languages")
    private List<String> languages;

    @Schema(description = "Border countries")
    private List<String> borders;

    @Schema(description = "Flag URL")
    private String flag;
}
