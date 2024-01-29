package com.ingaamira.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Clase que representa un producto en la tienda.
 */
@Data
@AllArgsConstructor
@Builder
public class Product {

    /**
     * ID único del producto.
     */
    private Integer productId;

    /**
     * Nombre del producto.
     */
    private String name;

    /**
     * Precio del producto.
     */
    private Double price;

    /**
     * Marca del producto.
     */
    private String brand;

    /**
     * Género al que está dirigido el producto.
     */
    private Gender gender;

    /**
     * Indica si el producto está activo o no.
     */
    private boolean active;

    /**
     * ID de la categoría a la que pertenece el producto.
     */
    private int categoryId;

}