package com.eshopapp.infrastructure.controller;

import com.eshopapp.application.services.ProductService;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> get(@PathVariable Integer productId) {
        return ResponseEntity.ok(this.productService.get(productId));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> add(@RequestBody ProductEntity productEntity) {
        if (productEntity.getProductId() == null || !this.productService.exists(productEntity.getProductId())) {
            return ResponseEntity.ok(this.productService.save(productEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity productEntity) {
        if (productEntity.getProductId() != null && this.productService.exists(productEntity.getProductId())) {
            return ResponseEntity.ok(this.productService.save(productEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Integer productId) {
        if (this.productService.exists(productId)) {
            this.productService.delete(productId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
