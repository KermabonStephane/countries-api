package com.demis27.countries.infrastructure.jpa.mapper

import com.demis27.countries.domain.Region
import com.demis27.countries.domain.SubRegion
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity
import com.demis27.countries.infrastructure.jpa.entity.SubRegionEntity
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class SubRegionEntityMapperSpec extends Specification {

    def mapper = Mappers.getMapper(SubRegionEntityMapper.class)

    def "should map SubRegionEntity to SubRegion domain"() {
        given:
        def regionEntity = new RegionEntity(code: 150, name: "Europe")
        def entity = new SubRegionEntity(code: 155, name: "Western Europe", region: regionEntity)

        when:
        SubRegion domain = mapper.toDomain(entity)

        then:
        domain.code == entity.code
        domain.name == entity.name
        domain.region.name == entity.region.name
    }

    def "should map SubRegion domain to SubRegionEntity"() {
        given:
        def domain = new SubRegion(code: 15, name: "Western Europe", region: new Region(code: 150, name: "Europe"))

        when:
        SubRegionEntity entity = mapper.toEntity(domain)

        then:
        entity.code == domain.code
        entity.name == domain.name
        entity.region.name == domain.region.name
        entity.region.code == domain.region.code
    }
}