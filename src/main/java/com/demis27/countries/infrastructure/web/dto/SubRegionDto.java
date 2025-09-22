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

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "Sub-region name", example = "Western Europe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Code is mandatory")
    @Schema(description = "SubRegion ISO code", example = "155", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int16")
    private Integer code;

    @Schema(description = "Parent region", example = "Europe")
    private SubRegionDto.RegionDto region;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Sub-Region Data Transfer Object")
    public static class RegionDto {
        @NotBlank(message = "Name is mandatory")
        @Schema(description = "Region name", example = "Europe", requiredMode = Schema.RequiredMode.REQUIRED)
        private String name;

        @NotBlank(message = "Code is mandatory")
        @Schema(description = "Region code", type = "integer", format = "int16", example = "142", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer code;
    }
}
