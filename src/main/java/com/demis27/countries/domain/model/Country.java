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
public class Country {
    private String id;
    private String alpha2Code;
    private String alpha3Code;
    private String name;
    private String nativeName;
    private String numericCode;
    private String region;
    private String subregion;
    private Long population;
    private Double area;
    private List<String> topLevelDomain;
    private List<String> currencies;
    private List<String> languages;
    private List<String> borders;
    private String flag;
}
