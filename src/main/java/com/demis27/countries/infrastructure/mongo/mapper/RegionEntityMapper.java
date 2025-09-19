package com.demis27.countries.infrastructure.mongo.mapper;

import com.demis27.countries.domain.model.Region;
import com.demis27.countries.infrastructure.mongo.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionEntityMapper {

    Region toDomain(RegionEntity entity);

    RegionEntity toEntity(Region domain);

    Region.SubRegion toDomain(RegionEntity.SubRegionEntity entity);

    RegionEntity.SubRegionEntity toEntity(Region.SubRegion domain);
}
