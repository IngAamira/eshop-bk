package com.eshopapp.infrastructure.adapter;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import com.eshopapp.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository, ProductMapper productMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Mono<ProductEntity> findById(Integer productId) {
        return productCrudRepository.findById(productId);
    }

    @Override
    public Mono<ProductEntity> save(ProductEntity productEntity) {
        return productCrudRepository.save(productEntity);
    }

    @Override
    public Mono<Void> deleteById(Integer productId) {
        return productCrudRepository.deleteById(productId);
    }

    @Override
    public Flux<ProductEntity> findAll() {
        return productCrudRepository.findAll();
    }
}