package com.eshopapp.infrastructure.adapter;

import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends R2dbcRepository<ProductEntity, Integer> {


}
