package com.eshopapp.infrastructure.controller;

import com.eshopapp.application.services.ProductServices;
import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/all")
    public Flux<Product> getAllProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Mono<Product> getProductById(@PathVariable Integer productId) {
        return productServices.getProductById(productId);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody ProductEntity productEntity) {
        return productServices.createProduct(productEntity);
    }

    @PutMapping("/{productId}")
    public Mono<Product> updateProduct(@PathVariable Integer productId, @RequestBody ProductEntity productEntity) {
        return productServices.updateProduct(productId, productEntity);
    }

    @DeleteMapping("/{productId}")
    public Mono<Void> deleteProduct(@PathVariable Integer productId) {
        return productServices.deleteProduct(productId);
    }

    @GetMapping("/byCategory/{categoryId}")
    public Flux<Product> getProductsByCategoryId(@PathVariable Integer categoryId) {
        return productServices.getProductsByCategoryId(categoryId);
    }

}