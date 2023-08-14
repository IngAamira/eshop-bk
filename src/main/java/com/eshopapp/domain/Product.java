package com.eshopapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Product {

    private Integer productId;
    private String name;
    private Double price;
    private String brand;
    private Character gender;
    private boolean active;

/*    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;*/

}
