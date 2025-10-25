package com.demis27.countries.infrastructure.jpa.repository;

import com.demis27.countries.infrastructure.jpa.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Integer> {

    List<CountryEntity> findCountryByRegionCode(Integer regionCode);

    List<CountryEntity> findCountryBySubRegionCode(Integer subRegionCode);
}
