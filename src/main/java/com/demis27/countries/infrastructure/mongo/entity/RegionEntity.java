package com.demis27.countries.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "regions")
public class RegionEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @Indexed(unique = true)
    private Integer code;

    private String description;
    private List<RegionEntity.SubRegionEntity> subRegions;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubRegionEntity {
        private String name;
        private Integer code;
    }
}
