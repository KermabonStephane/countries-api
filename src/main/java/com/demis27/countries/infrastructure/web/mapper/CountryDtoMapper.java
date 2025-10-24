package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.model.Country;
import com.demis27.countries.domain.model.Region;
import com.demis27.countries.domain.model.SubRegion;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryDtoMapper {

//    @Mapping(target = "region", ignore = true)
//    Country toDomain(CountryDto dto);

    CountryDto toDto(Country domain);

    CountryDto.RegionDto toDto(Region domain);

    CountryDto.SubRegionDto toDto(SubRegion domain);
}
