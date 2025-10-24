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
@Schema(description = "Region Data Transfer Object")
public class RegionDto {

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "Region name", example = "Europe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Code is mandatory")
    @Schema(description = "Region code", type = "integer", format = "int16", example = "142", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer code;
}
