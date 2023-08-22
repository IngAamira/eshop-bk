package com.eshopapp.application.repository;

import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository {

    Mono<ProductEntity> findById(Integer productId);
    Mono<ProductEntity> save(ProductEntity productEntity);
    Mono<Void> deleteById(Integer productId);
    Flux<ProductEntity> findAll();

    Flux<ProductEntity> getProductsByCategoryId(Integer categoryId);
}