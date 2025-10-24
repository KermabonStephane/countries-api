package com.demis27.countries.infrastructure.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class CountryEntity {

    @Id
    private Integer code;
    @Column(name = "alpha2_code", nullable = false, length = 2, unique = true)
    private String alpha2Code;
    @Column(name = "alpha3_code", nullable = false, length = 3, unique = true)
    private String alpha3Code;
    @Column(name = "name", nullable = false, length = 256)
    private String name;
    @ManyToOne
    @JoinColumn(name="code_region", referencedColumnName = "code")
    private RegionEntity region;
    @ManyToOne
    @JoinColumn(name="code_sub_region", referencedColumnName = "code")
    private SubRegionEntity subRegion;
}
