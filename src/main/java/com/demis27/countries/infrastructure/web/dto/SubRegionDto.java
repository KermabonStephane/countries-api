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
@Schema(description = "Sub-Region Data defined by the United Nations")
public class SubRegionDto {

    @NotBlank(message = "Code is mandatory")
    @Schema(description = "The unique numeric code of the sub-region.", type = "integer", format = "int16", example = "142", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer code;

    @NotBlank(message = "Name is mandatory")
    @Schema(description = "The English name of the sub-region.", example = "Western Europe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
}