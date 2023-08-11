package com.eshopapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@ToString
public class Product {

    private Integer id;
    private String code;
    private String name;
    private String description;
    private String brand;
    private String category;
    private Character gender;
    private BigDecimal price;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Product() {
        this.setCode(UUID.randomUUID().toString());
    }

}
