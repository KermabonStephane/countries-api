package com.demis27.countries.infrastructure.web.mapper

import com.demis27.countries.domain.Region
import com.demis27.countries.infrastructure.web.dto.RegionDto
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class RegionDtoMapperSpec extends Specification {

    def mapper = Mappers.getMapper(RegionDtoMapper.class)

    def "should map Region to RegionDto"() {
        given:
        def domain = new Region(code: 150, name: "Europe")

        when:
        RegionDto dto = mapper.toDto(domain)

        then:
        dto.code == domain.code
        dto.name == domain.name
    }

    def "should map RegionDto to Region"() {
        given:
        def dto = new RegionDto(code: 150, name: "Europe")

        when:
        Region domain = mapper.toDomain(dto)

        then:
        domain.code == dto.code
        domain.name == dto.name
    }
}