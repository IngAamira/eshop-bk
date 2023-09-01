package com.eshopapp.application.repository;

import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Repositorio para acceder y manipular datos relacionados con los productos.
 */
@Repository
public interface ProductRepository {

    /**
     * Encuentra un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return Un Mono que emite el producto encontrado, o vacío si no se encuentra.
     */
    Mono<ProductEntity> findById(Integer productId);


    /**
     * Guarda un nuevo producto o actualiza un producto existente.
     *
     * @param productEntity El producto a guardar o actualizar.
     * @return Un Mono que emite el producto guardado o actualizado.
     */
    Mono<ProductEntity> save(ProductEntity productEntity);


    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     * @return Un Mono que se completa una vez que se ha eliminado el producto.
     */
    Mono<Void> deleteById(Integer productId);


    /**
     * Obtiene todos los productos disponibles.
     *
     * @return Un Flux que emite una secuencia de productos disponibles.
     */
    Flux<ProductEntity> findAll();


    /**
     * Obtiene productos por su categoría.
     *
     * @param categoryId El ID de la categoría de productos.
     * @return Un Flux que emite productos pertenecientes a la categoría especificada.
     */
    Flux<ProductEntity> getProductsByCategoryId(Integer categoryId);

}