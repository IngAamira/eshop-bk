package com.eshopapp.application.repository;

import com.eshopapp.domain.Product;

public interface ProductRepository {

    Iterable<Product> getProducts();
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);

}
