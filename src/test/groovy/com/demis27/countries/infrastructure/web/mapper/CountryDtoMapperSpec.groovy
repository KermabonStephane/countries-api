package com.demis27.countries.infrastructure.web.mapper

import com.demis27.countries.domain.model.Country
import com.demis27.countries.infrastructure.web.dto.CountryDto
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class CountryDtoMapperSpec extends Specification {

    def mapper = Mappers.getMapper(CountryDtoMapper.class)

    def "should map CountryDto to Country"() {
        given:
        def dto = new CountryDto(
                id: 1L,
                name: "test",
                capital: "test",
                region: "test",
                subregion: "test",
                area: 1.0
        )

        when:
        def domain = mapper.toDomain(dto)

        then:
        domain.id == dto.id
        domain.name == dto.name
        domain.capital == dto.capital
        domain.region == dto.region
        domain.subregion == dto.subregion
        domain.area == dto.area
    }

    def "should map Country to CountryDto"() {
        given:
        def domain = new Country(
                id: 1L,
                name: "test",
                capital: "test",
                region: "test",
                subregion: "test",
                area: 1.0
        )

        when:
        def dto = mapper.toDto(domain)

        then:
        dto.id == domain.id
        dto.name == domain.name
        dto.capital == domain.capital
        dto.region == domain.region
        dto.subregion == domain.subregion
        dto.area == domain.area
    }
}
