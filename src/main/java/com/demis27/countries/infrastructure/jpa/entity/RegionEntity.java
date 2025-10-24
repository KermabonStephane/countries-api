package com.demis27.countries.infrastructure.jpa.entity;

import com.demis27.countries.domain.model.SubRegion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @ManyToMany
    private List<SubRegionEntity> subRegions;
    @ManyToMany
    private List<CountryEntity> countries;
}
