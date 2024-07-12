package com.logonedigital.gestion_stock_api.product.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaveProductResponse {
    private boolean isSaved;
    private String message;
    private Integer productId;

    public SaveProductResponse() {
        this.isSaved = false;
        this.message = "";
    }
}

