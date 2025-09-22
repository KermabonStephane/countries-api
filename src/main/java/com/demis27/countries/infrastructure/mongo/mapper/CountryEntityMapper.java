package com.demis27.countries.infrastructure.mongo.mapper;

import com.demis27.countries.domain.model.Country;
import com.demis27.countries.infrastructure.mongo.entity.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryEntityMapper {

    Country toDomain(CountryEntity entity);

    CountryEntity toEntity(Country domain);

    Country.Region toDomaine(CountryEntity.RegionEntity region);

    CountryEntity.RegionEntity toEntity(Country.Region region);

    Country.SubRegion toDomaine(CountryEntity.SubRegionEntity subRegion);

    CountryEntity.SubRegionEntity toEntity(Country.SubRegion subRegion);
}
