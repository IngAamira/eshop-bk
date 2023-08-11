package com.eshopapp.infrastructure.adapter;

import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findProductEntitiesById(Integer id);

    //Product save(Product product);
    //void delete(int productId);

}

