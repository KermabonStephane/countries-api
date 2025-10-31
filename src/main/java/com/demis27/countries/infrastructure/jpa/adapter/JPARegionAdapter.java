package com.demis27.countries.infrastructure.jpa.adapter;

import com.demis27.commons.restful.QueryParamFilter;
import com.demis27.countries.domain.Region;
import com.demis27.countries.infrastructure.jpa.entity.RegionEntity;
import com.demis27.countries.infrastructure.jpa.mapper.RegionEntityMapper;
import com.demis27.countries.infrastructure.jpa.repository.RegionEntityRepository;
import com.demis27.countries.service.RegionPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JPARegionAdapter implements RegionPort {

    private final RegionEntityRepository repository;
    private final RegionEntityMapper mapper;
    private final EntityManager entityManager;
    private final RegionSpecification specifications;

    @Override
    public List<Region> getAllRegions(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::toDomain).toList();
    }

    @Override
    public Long countRegions() {
        return repository.count();
    }

    @Override
    public Optional<Region> getRegion(Integer regionCode) {
        return repository.findById(regionCode).map(mapper::toDomain);
    }

    @Override
    public List<Region> getRegions(Pageable pageable, List<QueryParamFilter> filters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RegionEntity> criteriaQuery = criteriaBuilder.createQuery(RegionEntity.class);
        Root<RegionEntity> root = criteriaQuery.from(RegionEntity.class);

        criteriaQuery.where(specifications.fromFilters(filters).get().toPredicate(root, criteriaQuery, criteriaBuilder));

        return entityManager.createQuery(criteriaQuery).getResultStream().map(mapper::toDomain).toList();
    }
}
