package com.rak.agora.productservice.response;


import com.rak.agora.productservice.models.Category;
import java.time.Instant;

public record CategoryResponse(
        String id,
        String name,
        Instant createdOn,
        Instant updatedOn
) {
    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId().toString(),
                category.getName(),
                category.getCreatedOn(),
                category.getUpdatedOn());
    }
}
