package com.eshopapp.application.services;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProducts(){
        return  productRepository.getProducts();
    }

    public Product getProductById(Integer id){
        return  productRepository.getProductById(id);
    }

    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }

}
