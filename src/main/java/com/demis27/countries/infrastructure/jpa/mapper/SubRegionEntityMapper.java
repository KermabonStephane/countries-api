package com.demis27.countries.infrastructure.jpa.mapper;

import com.demis27.commons.restful.spring.infrastructure.jpa.EntityMapper;
import com.demis27.countries.domain.SubRegion;
import com.demis27.countries.infrastructure.jpa.entity.SubRegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubRegionEntityMapper extends EntityMapper<SubRegionEntity, SubRegion> {

    SubRegion toDomain(SubRegionEntity entity);

    SubRegionEntity toEntity(SubRegion domain);
}
