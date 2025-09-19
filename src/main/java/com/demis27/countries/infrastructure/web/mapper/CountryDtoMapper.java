package com.demis27.countries.infrastructure.web.mapper;

import com.demis27.countries.domain.model.Country;
import com.demis27.countries.infrastructure.web.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryDtoMapper {

    Country toDomain(CountryDto dto);

    CountryDto toDto(Country domain);
}
