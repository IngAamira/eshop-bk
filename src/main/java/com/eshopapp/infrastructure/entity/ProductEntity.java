package com.eshopapp.infrastructure.entity;

import com.eshopapp.domain.model.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entidad que representa un producto en la base de datos.
 */
@Table(name = "products")
@Builder
@Getter
@Setter
public class ProductEntity {

    /**
     * ID único del producto.
     */
    @Id
    @Column("product_id")
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
    @Column("category_id")
    private int categoryId;

}