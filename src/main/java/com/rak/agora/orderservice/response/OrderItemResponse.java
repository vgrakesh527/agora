package com.rak.agora.orderservice.response;

import com.rak.agora.orderservice.models.OrderItem;
import com.rak.agora.orderservice.models.OrderItemStatus;
import java.math.BigInteger;
import java.time.Instant;

public record OrderItemResponse(
    BigInteger orderItemId,
    String productId,
    int quantity,
    double amount,
    OrderItemStatus status,
    Instant createdOn,
    Instant updatedOn
) {
  public static OrderItemResponse toResponse(final OrderItem orderItem) {
    return new OrderItemResponse(
        orderItem.getId(),
        orderItem.getProductId().toString(),
        orderItem.getQuantity(),
        orderItem.getPrice(),
        orderItem.getStatus(),
        orderItem.getCreatedOn(),
        orderItem.getUpdatedOn());
  }
}
