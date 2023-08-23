package com.eshopapp.infrastructure.entity;

import com.eshopapp.domain.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "products")
@Builder
@Getter
@Setter
public class ProductEntity {

    @Id
    @Column("product_id")
    private Integer productId;

    private String name;
    private Double price;
    private String brand;
    private Gender gender;
    private boolean active;


    @Column("category_id")
    private Integer categoryId;

}
