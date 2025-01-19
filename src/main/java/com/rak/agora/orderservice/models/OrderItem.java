package com.rak.agora.orderservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "order_items")
@Setter
@Getter
public class OrderItem extends BaseModel{
  private UUID productId;
  private int quantity;
  private double price;

  @Enumerated(EnumType.STRING)
  private OrderItemStatus status;
}
