package com.rak.agora.orderservice.service.impl;

import com.rak.agora.orderservice.exceptions.OrderNotFoundException;
import com.rak.agora.orderservice.models.Order;
import com.rak.agora.orderservice.models.OrderItem;
import com.rak.agora.orderservice.payloads.OrderPayload;
import com.rak.agora.orderservice.repository.OrderRepository;
import com.rak.agora.orderservice.response.OrderResponse;
import com.rak.agora.orderservice.service.OrderItemService;
import com.rak.agora.orderservice.service.OrderService;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final OrderItemService orderItemService;

  @Override
  public OrderResponse getById(BigInteger id) throws Exception {
    return OrderResponse.toResponse(getId(id));
  }

  @Override
  public List<OrderResponse> getAll() {
    return orderRepository.findAll().stream().map(OrderResponse::toResponse).toList();
  }

  @Override
  public OrderResponse create(OrderPayload payload) throws Exception {
    var order = payload.toEntity();

    List<OrderItem> orderItems = orderItemService.saveAll(payload.orderItems());
    order.setOrderItems(orderItems);
    order = orderRepository.save(order);
    return OrderResponse.toResponse(order);
  }

  @Override
  public OrderResponse update(BigInteger id, OrderPayload payload) throws Exception {
    var order = getId(id);
    order.setTotalAmount(payload.totalPrice());
    order.setCustomerName(payload.userName());
    order.setTotalAmount(payload.totalPrice());
    order = orderRepository.save(order);
    return OrderResponse.toResponse(order);
  }

  @Override
  public void delete(BigInteger id) throws Exception {
    getId(id);
    orderRepository.deleteById(id);
  }

  private Order getId(BigInteger id) throws Exception {
    return orderRepository.findById(id)
        .orElseThrow(() -> new OrderNotFoundException("Odr001", id + " is not available!!"));
  }

}
