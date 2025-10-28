package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.Country;
import com.demis27.countries.domain.Region;
import com.demis27.countries.domain.SubRegion;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryDtoMapper {

    CountryDto toDto(Country domain);

    CountryDto.RegionDto toDto(Region domain);

    CountryDto.SubRegionDto toDto(SubRegion domain);

    Country toDomain(CountryDto dto);

    Region toDomain(CountryDto.RegionDto dto);

    SubRegion toDomain(CountryDto.SubRegionDto dto);
}
