package com.rak.agora.orderservice.payloads;

import com.rak.agora.orderservice.models.OrderItem;
import java.util.UUID;

public record OrderItemPayload(
    String productId,
    int quantity,
    double amount
) {
  public OrderItem toEntity() {
    OrderItem orderItem = new OrderItem();
    orderItem.setProductId(UUID.fromString(productId));
    orderItem.setQuantity(quantity);
    orderItem.setPrice(amount);
    return orderItem;
  }
}
