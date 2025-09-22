package com.demis27.countries.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubRegion {
    private String id;
    private String name;
    private SubRegion.Region region;
    private Integer code;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Region {
        private String name;
        private Integer code;
    }
}
