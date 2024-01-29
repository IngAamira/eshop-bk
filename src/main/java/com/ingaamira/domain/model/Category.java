package com.ingaamira.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * Clase que representa una categoría de productos en la tienda.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    /**
     * ID único de la categoría.
     */
    private Integer categoryId;

    /**
     * Descripción de la categoría.
     */
    private String description;

    /**
     * Indica si la categoría está activa o no.
     */
    private Boolean active;

    /**
     * Flujo reactivo de productos asociados a esta categoría.
     */
    private Flux<Product> products;

}