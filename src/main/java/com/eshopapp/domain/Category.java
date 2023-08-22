package com.eshopapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class Category {

    private Integer categoryId;
    private String description;
    private Boolean active;
}
