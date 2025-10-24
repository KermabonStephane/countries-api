package com.demis27.countries.infrastructure.jpa.mapper;

import com.demis27.countries.domain.model.Country;
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RegionEntityMapper.class, SubRegionEntityMapper.class})
public interface CountryEntityMapper {

    Country toDomain(CountryEntity entity);
}
