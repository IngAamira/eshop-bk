package com.eshopapp.infrastructure.configuration;

import com.eshopapp.application.repository.ProductRepository;
import com.eshopapp.application.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductService(productRepository);
    }

}
