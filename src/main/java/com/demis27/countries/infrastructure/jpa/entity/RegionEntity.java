package com.demis27.countries.infrastructure.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "region")
public class RegionEntity {

    @Id
    private Integer code;
    @Column(name = "name", nullable = false, length = 256)
    private String name;
}
