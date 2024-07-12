package com.logonedigital.gestion_stock_api.product.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
    private Date createdAt;
    private Date updatedAt;

    // Getters and Setters
}

