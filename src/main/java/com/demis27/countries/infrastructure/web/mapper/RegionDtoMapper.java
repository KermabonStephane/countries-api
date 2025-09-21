package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.model.Region;
import com.demis27.countries.infrastructure.web.dto.RegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionDtoMapper {

    @Mapping(target = "id", ignore = true)
    Region toDomain(RegionDto dto);

    RegionDto toDto(Region domain);

    Region.SubRegion toDomain(RegionDto.SubRegionDto dto);

    RegionDto.SubRegionDto toDto(Region.SubRegion domain);
}
