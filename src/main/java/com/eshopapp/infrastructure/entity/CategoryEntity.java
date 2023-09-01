package com.eshopapp.infrastructure.entity;

import com.eshopapp.domain.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

/**
 * Entidad que representa una categoría de productos en la base de datos.
 */
@Table(name = "categories")
@Data
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
    @NotBlank(message = "la descripción de la categoría no puede estar vacío")
    private String description;

    /**
     * Indica si la categoría está activa o no.
     * Valor predeterminado: true
     */
    private boolean active = true;

    /**
     * Flujo reactivo de productos asociados a esta categoría.
     */
    private Flux<Product> products;

}
