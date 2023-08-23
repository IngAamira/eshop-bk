package com.eshopapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import reactor.core.publisher.Flux;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Category {

    private Integer categoryId;
    private String description;
    private Boolean active;

    private Flux<Product> products;

}