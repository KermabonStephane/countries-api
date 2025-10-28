package com.demis27.countries.infrastructure.jpa.mapper

import com.demis27.countries.domain.Region
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class RegionEntityMapperSpec extends Specification {

    def mapper = Mappers.getMapper(RegionEntityMapper.class)

    def "should map RegionEntity to Region domain"() {
        given:
        def entity = new RegionEntity(code: 150, name: "Europe")

        when:
        Region domain = mapper.toDomain(entity)

        then:
        domain.code == entity.code
        domain.name == entity.name
    }

    def "should map Region domain to RegionEntity"() {
        given:
        def domain = new Region(code: 150, name: "Europe")

        when:
        RegionEntity entity = mapper.toEntity(domain)

        then:
        entity.code == domain.code
        entity.name == domain.name

    }
}