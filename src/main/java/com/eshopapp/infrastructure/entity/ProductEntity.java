package com.eshopapp.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "products")
@Getter
@Setter
@Builder
public class ProductEntity {

    @Id
    private Integer productId;

    private String name;
    private Double price;
    private String brand;
    private Character gender;
    private boolean active;

}
