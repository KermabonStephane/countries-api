package com.demis27.countries.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
    @Indexed(unique = true)
    private String code;
    private String region;
    private String subregion;
}
