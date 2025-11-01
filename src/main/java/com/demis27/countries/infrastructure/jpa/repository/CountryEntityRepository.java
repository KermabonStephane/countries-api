package com.demis27.countries.infrastructure.jpa.repository;

import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceRepository;
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity;

import java.util.List;

public interface CountryEntityRepository extends JpaResourceRepository<CountryEntity, Integer> {

    List<CountryEntity> findCountryByRegionCode(Integer regionCode);

    List<CountryEntity> findCountryBySubRegionCode(Integer subRegionCode);
}
