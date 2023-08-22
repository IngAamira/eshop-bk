package com.eshopapp.infrastructure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "categories")
@Getter
@Setter
public class CategoryEntity {

    @Id
    @Column("category_id")
    private Integer categoryId;

    private String description;
    private Boolean active;

}
