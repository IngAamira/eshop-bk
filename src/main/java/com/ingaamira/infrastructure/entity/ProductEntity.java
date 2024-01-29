package com.ingaamira.infrastructure.entity;

import com.ingaamira.domain.model.Gender;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entidad que representa un producto en la base de datos.
 */
@Table(name = "products")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;

    /**
     * Precio del producto.
     */
    @NotNull(message = "El precio del producto no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El precio debe ser igual o mayor a 0")
    private Double price;

    /**
     * Marca del producto.
     */
    private String brand;

    /**
     * Género al que está dirigido el producto.
     */
    @NotNull(message = "El género del producto no puede estar vacío")
    private Gender gender;

    /**
     * Indica si el producto está activo o no.
     * Valor predeterminado: true
     */
    private boolean active = true;

    /**
     * ID de la categoría a la que pertenece el producto.
     */
    @Column("category_id")
    private int categoryId;

}
