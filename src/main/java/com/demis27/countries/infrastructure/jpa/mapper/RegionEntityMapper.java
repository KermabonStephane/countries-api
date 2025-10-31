package com.demis27.countries.infrastructure.jpa.mapper;

import com.demis27.commons.restful.spring.infrastructure.jpa.EntityMapper;
import com.demis27.countries.domain.Region;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionEntityMapper extends EntityMapper<RegionEntity, Region> {

    Region toDomain(RegionEntity entity);

    RegionEntity toEntity(Region domain);
}
