package com.rak.agora.orderservice.response;

import com.rak.agora.orderservice.models.Order;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

public record OrderResponse(
    BigInteger orderId,
    String userName,
    double totalPrice,
    List<OrderItemResponse> orderItems,
    Instant createdOn,
    Instant updatedOn
) {
  public static OrderResponse toResponse(Order order) {
    return new OrderResponse(
        order.getId(),
        order.getCustomerName(),
        order.getTotalAmount(),
        (!order.getOrderItems().isEmpty()) ?
            order.getOrderItems().stream().map(OrderItemResponse::toResponse).toList() :
            Collections.emptyList(),
        order.getCreatedOn(),
        order.getUpdatedOn()
    );
  }
}
