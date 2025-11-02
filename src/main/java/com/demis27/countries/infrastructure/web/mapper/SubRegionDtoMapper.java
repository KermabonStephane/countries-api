package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.SubRegion;
import com.demis27.countries.infrastructure.web.dto.SubRegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubRegionDtoMapper {

    SubRegionDto toDto(SubRegion domain);

    @Mapping(target = "region", ignore = true)
    SubRegion toDomain(SubRegionDto dto);
}
