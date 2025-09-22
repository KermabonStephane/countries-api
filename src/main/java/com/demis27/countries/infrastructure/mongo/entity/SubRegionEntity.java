package com.demis27.countries.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "subregions")
public class SubRegionEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @Indexed(unique = true)
    private String code;

    private SubRegionEntity.RegionEntity region;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegionEntity {
        private String name;
        private String code;
    }
}
