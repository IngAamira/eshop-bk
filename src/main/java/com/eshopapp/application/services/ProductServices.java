package com.eshopapp.application.services;

import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.adapter.ProductReactiveRepository;
import com.eshopapp.infrastructure.entity.ProductEntity;
import com.eshopapp.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServices {

    private final ProductReactiveRepository productReactiveRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServices(ProductReactiveRepository productReactiveRepository, ProductMapper productMapper) {
        this.productReactiveRepository = productReactiveRepository;
        this.productMapper = productMapper;
    }

    public Mono<Product> getProductById(Integer productId) {
        return productReactiveRepository.findById(productId)
                .map(productMapper::toProduct);
    }

    public Flux<Product> getAllProducts() {
        return productReactiveRepository.findAll()
                .map(productMapper::toProduct);
    }

    public Mono<Product> createProduct(ProductEntity productEntity) {
        return productReactiveRepository.save(productEntity)
                .map(productMapper::toProduct);
    }

    public Mono<Product> updateProduct(Integer productId, ProductEntity productEntity) {
        return productReactiveRepository.findById(productId)
                .flatMap(existingProduct -> {
                    existingProduct.setName(productEntity.getName());
                    existingProduct.setPrice(productEntity.getPrice());
                    return productReactiveRepository.save(existingProduct);
                })
                .map(productMapper::toProduct);
    }

    public Mono<Void> deleteProduct(Integer productId) {
        return productReactiveRepository.deleteById(productId);
    }

    private Product mapToDomain(ProductEntity productEntity) {
        return productMapper.toProduct(productEntity);
    }

    public Flux<Product> getProductsByCategoryId(Integer categoryId) {
        return productReactiveRepository.findByCategoryId(categoryId)
                .map(productMapper::toProduct);
    }

}