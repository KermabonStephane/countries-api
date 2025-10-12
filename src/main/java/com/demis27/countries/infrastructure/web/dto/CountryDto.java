package com.demis27.countries.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Country Data Transfer Object")
public class CountryDto {

    @NotBlank(message = "Alpha2 code is mandatory")
    @Size(min = 2, max = 2, message = "Alpha2 code must be exactly 2 characters")
    @Schema(description = "ISO 3166-1 alpha-2 code", example = "FR", requiredMode = REQUIRED)
    private String alpha2Code;

    @NotBlank(message = "Alpha3 code is mandatory")
    @Size(min = 3, max = 3, message = "Alpha3 code must be exactly 3 characters")
    @Schema(description = "ISO 3166-1 alpha-3 code", example = "FRA", requiredMode = REQUIRED)
    private String alpha3Code;

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "Country name", example = "France", requiredMode = REQUIRED)
    private String name;

    @Schema(description = "ISO 3166-1 numeric code", example = "250", requiredMode = REQUIRED, type = "integer", format = "int16")
    private Integer code;
}
