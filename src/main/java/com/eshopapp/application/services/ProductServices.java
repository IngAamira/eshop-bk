package com.eshopapp.application.services;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> getProductById(Integer productId) {
        return productRepository.findById(productId);
    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> createProduct(ProductEntity productEntity) {
        return (Mono<Product>) productRepository.save(productEntity);
    }

    public Mono<Product> updateProduct(Integer productId, ProductEntity productEntity) {
        return productRepository.findById(productId)
                .flatMap(existingProduct -> {
                    existingProduct.setName(productEntity.getName());
                    existingProduct.setPrice(productEntity.getPrice());
                    // Actualizar más propiedades según sea necesario
                    return productRepository.save(productEntity);
                });
    }

    public Mono<Void> deleteProduct(Integer productId) {
        return productRepository.deleteById(productId);
    }

}
