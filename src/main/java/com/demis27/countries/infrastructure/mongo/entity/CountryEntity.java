package com.demis27.countries.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "countries")
public class CountryEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String alpha2Code;

    @Indexed(unique = true)
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
