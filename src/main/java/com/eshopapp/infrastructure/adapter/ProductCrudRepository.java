package com.eshopapp.infrastructure.adapter;

import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductCrudRepository extends R2dbcRepository<ProductEntity, Integer> {

    Flux<ProductEntity> findByCategoryId(Integer categoryId);

}
