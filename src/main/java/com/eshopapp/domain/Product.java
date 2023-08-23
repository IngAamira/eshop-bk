package com.eshopapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class Product {

    private Integer productId;
    private String name;
    private Double price;
    private String brand;
    private Gender gender;
    private boolean active;
    private Integer categoryId;

}
