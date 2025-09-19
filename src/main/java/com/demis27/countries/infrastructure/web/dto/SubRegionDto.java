package com.demis27.countries.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Sub-Region Data Transfer Object")
public class SubRegionDto {

    @Schema(description = "Unique identifier", example = "507f1f77bcf86cd799439011")
    private String id;

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "Sub-region name", example = "Western Europe", required = true)
    private String name;

    @Schema(description = "Parent region", example = "Europe")
    private String region;

    @Schema(description = "Sub-region description", example = "Western European countries")
    private String description;
}
