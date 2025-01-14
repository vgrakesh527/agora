package com.rak.agora.productservice.payloads;

import com.rak.agora.productservice.models.Product;

public record ProductPayload(
    String title,
    String description,
    double price,
    String categoryId
) {
  public Product toEntity() {
    Product product = new Product();
    product.setTitle(title);
    product.setDescription(description);
    product.setPrice(price);
    return product;
  }
}
