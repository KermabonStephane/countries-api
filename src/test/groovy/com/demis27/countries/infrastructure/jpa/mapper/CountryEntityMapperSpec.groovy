package com.demis27.countries.infrastructure.jpa.mapper

import com.demis27.countries.domain.model.Country
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity
import com.demis27.countries.infrastructure.jpa.entity.SubRegionEntity
import com.demis27.countries.infrastructure.web.mapper.RegionDtoMapper
import org.mapstruct.factory.Mappers
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class CountryEntityMapperSpec extends Specification {

    def mapper = Mappers.getMapper(CountryEntityMapper.class)

    def "should map CountryEntity to Country domain"() {
        given:
        def entity = new CountryEntity(
                code: 250,
                alpha2Code: "FR",
                alpha3Code: "FRA",
                name: "France"
        )

        when:
        Country domain = mapper.toDomain(entity)

        then:
        domain.code == entity.code
        domain.alpha2Code == entity.alpha2Code
        domain.alpha3Code == entity.alpha3Code
        domain.name == entity.name
    }
}