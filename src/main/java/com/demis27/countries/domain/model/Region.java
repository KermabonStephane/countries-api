package com.demis27.countries.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    private String id;
    private String name;
    private String description;
    private Integer code;
    private List<Region.SubRegion> subRegions;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubRegion {
        private String name;
        private Integer code;
    }
}
