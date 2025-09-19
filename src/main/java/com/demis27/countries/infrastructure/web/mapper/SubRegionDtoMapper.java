package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.web.dto.SubRegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubRegionDtoMapper {

    SubRegion toDomain(SubRegionDto dto);

    SubRegionDto toDto(SubRegion domain);
}
