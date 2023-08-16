package com.eshopapp.application.repository;

import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository {

    Mono<Product> findById(Integer productId);
    Mono<Product> save(ProductEntity productEntity);
    Mono<Void> deleteById(Integer productId);
    Flux<Product> findAll();



}