package com.eshopapp.infrastructure.adapter;

import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Repositorio reactivo para acceder y manipular datos relacionados con los productos.
 */
@Repository
public interface ProductReactiveRepository extends R2dbcRepository<ProductEntity, Integer> {

    /**
     * Obtiene productos por su categoría.
     *
     * @param categoryId El ID de la categoría de productos.
     * @return Un Flux que emite productos pertenecientes a la categoría especificada.
     */
    Flux<ProductEntity> findByCategoryId(Integer categoryId);

}