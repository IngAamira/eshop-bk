package com.eshopapp.application.services;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

     public List<ProductEntity> getAll() {
        return this.productRepository.findAll();
    }

    public ProductEntity get(Integer productId) {
        return this.productRepository.findById(productId).orElse(null);
    }

    public ProductEntity save(ProductEntity productEntity) {
        return this.productRepository.save(productEntity);
    }

    public void delete(Integer productId) {
        this.productRepository.deleteById(productId);
    }

    public boolean exists(Integer productId) {
        return this.productRepository.existsById(productId);
    }

}
