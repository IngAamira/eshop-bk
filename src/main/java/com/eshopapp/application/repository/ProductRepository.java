package com.eshopapp.application.repository;

import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<ProductEntity, Integer> {


}
