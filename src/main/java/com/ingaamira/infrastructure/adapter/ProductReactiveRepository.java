package com.ingaamira.infrastructure.adapter;

import com.ingaamira.infrastructure.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
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


    /**
     * Obtiene productos por nombre con paginación.
     *
     * @param name     El nombre por el cual filtrar los productos.
     * @param pageable La información de paginación.
     * @return Un Flux que emite productos que coinciden con el nombre especificado y la paginación.
     */
    Flux<ProductEntity> findAllByNameContaining(String name, Pageable pageable);

}