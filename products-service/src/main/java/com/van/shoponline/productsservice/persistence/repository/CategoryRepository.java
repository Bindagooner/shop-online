package com.van.shoponline.productsservice.persistence.repository;

import com.van.shoponline.productsservice.persistence.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends PagingAndSortingRepository<CategoryEntity, Long> {
    @RestResource(path = "byName", rel = "byName")
    Page<CategoryEntity> findByNameContainingIgnoreCase(@Param("name") String name, Pageable p);
}
