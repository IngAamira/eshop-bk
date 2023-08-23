package com.eshopapp.application.services;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import com.eshopapp.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServices {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServices(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Mono<Product> getProductById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProduct);
    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll()
                .map(productMapper::toProduct);
    }

    public Mono<Product> createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity)
                .map(productMapper::toProduct);
    }

    public Mono<Product> updateProduct(Integer productId, ProductEntity productEntity) {
        return productRepository.findById(productId)
                .flatMap(existingProduct -> {
                    existingProduct.setName(productEntity.getName());
                    existingProduct.setPrice(productEntity.getPrice());

                    return productRepository.save(existingProduct)
                            .map(productMapper::toProduct);
                });
    }

    public Mono<Void> deleteProduct(Integer productId) {
        return productRepository.deleteById(productId);
    }

    private Product mapToDomain(ProductEntity productEntity) {
        return productMapper.toProduct(productEntity);
    }

    public Flux<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.getProductsByCategoryId(categoryId)
                .map(productMapper::toProduct);
    }

}