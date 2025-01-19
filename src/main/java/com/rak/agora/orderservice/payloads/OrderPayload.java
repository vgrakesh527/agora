package com.rak.agora.orderservice.payloads;

import com.rak.agora.orderservice.models.Order;
import java.util.List;

public record OrderPayload
    (
        String userName,
        double totalPrice,
        List<OrderItemPayload> orderItems
    ) {
  public Order toEntity() {
    Order order = new Order();
    order.setCustomerName(userName);
    order.setTotalAmount(totalPrice);
    return order;
  }
}
