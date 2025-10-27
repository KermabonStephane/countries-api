package com.demis27.countries.infrastructure.jpa.mapper

import com.demis27.countries.domain.model.Country
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity
import com.demis27.countries.infrastructure.jpa.entity.SubRegionEntity
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class CountryEntityMapperSpec extends Specification {

    def mapper = Mappers.getMapper(CountryEntityMapper.class)

    def "should map CountryEntity to Country domain"() {
        given:
        def regionEntity = new RegionEntity(code: 150, name: "Europe")
        def subRegionEntity = new SubRegionEntity(code: 155, name: "Western Europe", region: regionEntity)
        def entity = new CountryEntity(
                code: 250,
                alpha2Code: "FR",
                alpha3Code: "FRA",
                name: "France",
                region: regionEntity,
                subRegion: subRegionEntity
        )

        when:
        Country domain = mapper.toDomain(entity)

        then:
        domain.code == entity.code
        domain.alpha2Code == entity.alpha2Code
        domain.alpha3Code == entity.alpha3Code
        domain.name == entity.name
        domain.region.name == entity.region.name
        domain.subRegion.name == entity.subRegion.name
    }
}