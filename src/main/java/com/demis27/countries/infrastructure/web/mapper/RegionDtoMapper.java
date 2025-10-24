package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.model.Region;
import com.demis27.countries.infrastructure.web.dto.RegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionDtoMapper {

    RegionDto toDto(Region domain);
}
