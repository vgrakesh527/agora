package com.rak.agora.productservice.response;

import com.rak.agora.productservice.models.Product;
import java.time.Instant;
import java.util.Optional;

public record ProductResponse(
        String productId,
        String title,
        String description,
        double price,
        String category,
        Instant createdOn,
        Instant updatedOn
) {
    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId().toString(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                Optional.ofNullable(product.getCategory()).isPresent() ? product.getCategory().getName() : null,
                product.getCreatedOn(),
                product.getUpdatedOn());
    }
}
