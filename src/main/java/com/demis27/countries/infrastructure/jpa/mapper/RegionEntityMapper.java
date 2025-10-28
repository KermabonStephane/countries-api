package com.demis27.countries.infrastructure.jpa.mapper;

import com.demis27.countries.domain.Region;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SubRegionEntityMapper.class})
public interface RegionEntityMapper {

    Region toDomain(RegionEntity entity);
}
