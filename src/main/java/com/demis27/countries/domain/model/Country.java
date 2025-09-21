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
    private String region;
    private String subregion;
}
