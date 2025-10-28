package com.demis27.countries.infrastructure.web.mapper

import com.demis27.countries.domain.Country
import com.demis27.countries.domain.Region
import com.demis27.countries.domain.SubRegion
import com.demis27.countries.infrastructure.web.dto.CountryDto
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class CountryDtoMapperSpec extends Specification {

    def mapper = Mappers.getMapper(CountryDtoMapper.class)

    def "should map Country to CountryDto"() {
        given:
        def regionDomain = new Region(code: 150, name: "Europe")
        def subRegionDomain = new SubRegion(code: 155, name: "Western Europe", region: regionDomain)
        def domain = new Country(
                code: 250,
                alpha2Code: "FR",
                alpha3Code: "FRA",
                name: "France",
                region: regionDomain,
                subRegion: subRegionDomain
        )

        when:
        def dto = mapper.toDto(domain)

        then:
        dto.code == domain.code
        dto.alpha2Code == domain.alpha2Code
        dto.alpha3Code == domain.alpha3Code
        dto.name == domain.name
        dto.region != null
        dto.region.code == domain.region.code
        dto.region.name == domain.region.name
        dto.subRegion != null
        dto.subRegion.code == domain.subRegion.code
        dto.subRegion.name == domain.subRegion.name
    }

    def "should map Region to RegionDto"() {
        given:
        def domain = new Region(code: 150, name: "Europe")

        when:
        CountryDto.RegionDto dto = mapper.toDto(domain)

        then:
        dto.code == domain.code
        dto.name == domain.name
    }

    def "should map SubRegion to SubRegionDto"() {
        given:
        def regionDomain = new Region(code: 150, name: "Europe")
        def domain = new SubRegion(code: 155, name: "Western Europe", region: regionDomain)

        when:
        CountryDto.SubRegionDto dto = mapper.toDto(domain)

        then:
        dto.code == domain.code
        dto.name == domain.name
    }

}
