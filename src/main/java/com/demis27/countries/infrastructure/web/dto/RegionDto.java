package com.demis27.countries.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Region Data Transfer Object")
public class RegionDto {

    @Schema(description = "Unique identifier", example = "507f1f77bcf86cd799439011")
    private String id;

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "Region name", example = "Europe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Code is mandatory")
    @Schema(description = "Region code", type = "integer", format = "int16", example = "142", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer code;

    @Schema(description = "Region description", example = "European countries")
    private String description;

    @Schema(description = "List of sub-regions")
    private List<RegionDto.SubRegionDto> subRegions;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubRegionDto {
        @Schema(description = "Sub-region name", example = "Western Europe")
        private String name;
        @Schema(description = "Sub-region code", type = "integer", format = "int16", example = "155")
        private Integer code;

    }
}
