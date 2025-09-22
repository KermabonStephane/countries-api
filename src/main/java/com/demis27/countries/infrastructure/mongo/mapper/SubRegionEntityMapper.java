package com.demis27.countries.infrastructure.mongo.mapper;

import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.mongo.entity.SubRegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubRegionEntityMapper {

    SubRegion toDomain(SubRegionEntity entity);

    SubRegionEntity toEntity(SubRegion domain);

    SubRegion.Region toDomain(SubRegionEntity.RegionEntity entity);

    SubRegionEntity.RegionEntity toEntity(SubRegion.Region region);
}
