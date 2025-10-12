package com.demis27.countries.infrastructure.jpa.repository;

import com.demis27.countries.infrastructure.jpa.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Integer> {
}
