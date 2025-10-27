package com.demis27.countries.infrastructure.web.mapper

import com.demis27.countries.domain.model.Region
import com.demis27.countries.domain.model.SubRegion
import com.demis27.countries.infrastructure.web.dto.SubRegionDto
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class SubRegionDtoMapperSpec extends Specification {

    def mapper = Mappers.getMapper(SubRegionDtoMapper.class)

    def "should map SubRegion to SubRegionDto"() {
        given:
        def regionDomain = new Region(code: 150, name: "Europe")
        def domain = new SubRegion(code: 155, name: "Western Europe", region: regionDomain)

        when:
        SubRegionDto dto = mapper.toDto(domain)

        then:
        dto.code == domain.code
        dto.name == domain.name
    }
}