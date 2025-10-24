package com.demis27.countries.infrastructure.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sub_region")
public class SubRegionEntity {

    @Id
    private Integer code;
    @Column(name = "name", nullable = false, length = 256)
    private String name;
    @ManyToOne
    @JoinColumn(name = "code_region", referencedColumnName = "code")
    private RegionEntity region;
    @OneToMany
    @JoinColumn(name = "code")
    private List<CountryEntity> countries;
}
