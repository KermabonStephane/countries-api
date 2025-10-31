package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.spring.filtering.SpecificationService;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import org.springframework.stereotype.Service;

@Service
public class RegionSpecification extends SpecificationService<RegionEntity> {
}
