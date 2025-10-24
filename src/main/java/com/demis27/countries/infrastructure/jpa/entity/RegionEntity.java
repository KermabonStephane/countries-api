package com.demis27.countries.infrastructure.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "region")
public class RegionEntity {

    @Id
    private Integer code;
    @Column(name = "name", nullable = false, length = 256)
    private String name;
    @OneToMany
    @JoinColumn(name="code")
    private List<SubRegionEntity> subRegions;
    @OneToMany
    @JoinColumn(name="code")
    private List<CountryEntity> countries;
}
