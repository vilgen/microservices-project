package com.mapkloud.product_service.util;

import com.mapkloud.product_service.dto.ProductResponse;
import com.mapkloud.product_service.model.Product;

public final class ProductHelper {

    public static ProductResponse convertProductToProductResponse(Product product) {
        return ProductResponse.ProductResponseBuilder.aProductResponse()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
