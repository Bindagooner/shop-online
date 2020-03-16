package com.van.shoponline.productsservice.persistence.repository;

import com.van.shoponline.productsservice.persistence.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long> {
    @RestResource(path = "byName", rel = "byName")
    Page<ProductEntity> findByNameContainingIgnoreCase(@Param("name") String name, Pageable p);

    @RestResource(path = "byBrand", rel = "byBrand")
    Page<ProductEntity> findByBrandContainingIgnoreCase(@Param("brand") String brand, Pageable p);

    @RestResource(path = "byColor", rel = "byColor")
    Page<ProductEntity> findByColorIgnoreCase(@Param("color") String color, Pageable p);

    @RestResource(path = "byCategory", rel = "byCategory")
    Page<ProductEntity> findByCategory_Id(@Param("category") Long categoryId, Pageable p);
}
