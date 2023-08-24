package com.eshopapp.infrastructure.entity;

import com.eshopapp.domain.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

/**
 * Entidad que representa una categoría de productos en la base de datos.
 */
@Table(name = "categories")
@Getter
@Setter
public class CategoryEntity {

    /**
     * ID único de la categoría.
     */
    @Id
    @Column("category_id")
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
