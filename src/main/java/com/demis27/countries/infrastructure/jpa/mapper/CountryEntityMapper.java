package com.demis27.countries.infrastructure.jpa.mapper;

import com.demis27.commons.restful.spring.infrastructure.jpa.EntityMapper;
import com.demis27.countries.domain.Country;
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryEntityMapper extends EntityMapper<CountryEntity, Country> {

    Country toDomain(CountryEntity entity);

    CountryEntity toEntity(Country domain);
}
