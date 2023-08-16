package com.eshopapp.infrastructure.controller;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Mono<Product> getProductById(@PathVariable Integer productId) {
        return productRepository.findById(productId);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @PutMapping("/{productId}")
    public Mono<Product> updateProduct(@PathVariable Integer productId, @RequestBody ProductEntity productEntity) {
        return productRepository.findById(productId)
                .flatMap(existingProduct -> {
                    existingProduct.setName(productEntity.getName());
                    existingProduct.setPrice(productEntity.getPrice());
                    // Actualizar más propiedades según sea necesario
                    return productRepository.save(productEntity);
                });
    }

    @DeleteMapping("/{productId}")
    public Mono<Void> deleteProduct(@PathVariable Integer productId) {
        return productRepository.deleteById(productId);
    }

}
