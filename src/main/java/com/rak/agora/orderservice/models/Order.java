package com.rak.agora.orderservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
public class Order extends BaseModel {
  private String customerName;
  private double totalAmount;

  @OneToMany
  private List<OrderItem> orderItems;
}
