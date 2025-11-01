package com.demis27.countries.infrastructure.jpa.repository;

import com.demis27.commons.restful.spring.infrastructure.jpa.JpaResourceRepository;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionEntityRepository extends JpaResourceRepository<RegionEntity, Integer> {
}
