package com.demis27.countries.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String id;
    private String alpha2Code;
    private String alpha3Code;
    private String name;
    private Integer code;
    private Country.Region region;
    private Country.SubRegion subregion;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Region {
        private String name;
        private Integer code;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubRegion {
        private String name;
        private Integer code;
    }
}
