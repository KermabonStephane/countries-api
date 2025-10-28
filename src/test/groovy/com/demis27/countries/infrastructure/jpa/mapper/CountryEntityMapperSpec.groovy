package com.demis27.countries.infrastructure.jpa.mapper

import com.demis27.countries.domain.Country
import com.demis27.countries.domain.Region
import com.demis27.countries.domain.SubRegion
import com.demis27.countries.infrastructure.jpa.entity.CountryEntity
import org.mapstruct.factory.Mappers
import spock.lang.Ignore
import spock.lang.Specification

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

    def "should map Country domain to CountryEntity"() {
        given:
        def domain = new Country(
                code: 250,
                alpha2Code: "FR",
                alpha3Code: "FRA",
                name: "France",
                region: new Region(
                        code: 150,
                        name: "Europe"),
                subRegion: new SubRegion(
                        code: 15,
                        name: "Western Europe",
                        region: new Region(
                                code: 150,
                                name: "Europe")))

        when:
        CountryEntity entity = mapper.toEntity(domain)

        then:
        entity.code == domain.code
        entity.alpha2Code == domain.alpha2Code
        entity.alpha3Code == domain.alpha3Code
        entity.name == domain.name
        entity.region.name == domain.region.name
        entity.region.code == domain.region.code
        entity.subRegion.name == domain.subRegion.name
        entity.subRegion.code == domain.subRegion.code
        entity.subRegion.region.name == domain.subRegion.region.name
        entity.subRegion.region.code == domain.subRegion.region.code
    }
}