package com.rak.agora.orderservice.service.impl;

import com.rak.agora.orderservice.exceptions.OrderItemNotFoundException;
import com.rak.agora.orderservice.models.OrderItem;
import com.rak.agora.orderservice.models.OrderItemStatus;
import com.rak.agora.orderservice.payloads.OrderItemPayload;
import com.rak.agora.orderservice.repository.OrderItemRepository;
import com.rak.agora.orderservice.response.OrderItemResponse;
import com.rak.agora.orderservice.service.OrderItemService;
import com.rak.agora.productservice.service.ProductService;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
  private final OrderItemRepository orderItemRepository;
  private final ProductService productService;

  @Override
  public OrderItemResponse getById(BigInteger id) throws Exception {
    return OrderItemResponse.toResponse(getId(id));
  }

  @Override
  public List<OrderItemResponse> getAll() {
    return orderItemRepository.findAll().stream().map(OrderItemResponse::toResponse).toList();
  }

  @Override
  public OrderItemResponse create(OrderItemPayload payload) throws Exception {
    OrderItem orderItem = payload.toEntity();
    orderItem.setStatus(OrderItemStatus.PENDING);
    orderItem = orderItemRepository.save(orderItem);
    return OrderItemResponse.toResponse(orderItem);
  }

  @Override
  public OrderItemResponse update(BigInteger id, OrderItemPayload payload) throws Exception {
    OrderItem orderItem = getId(id);
    productService.getProduct(payload.productId());
    orderItem.setPrice(payload.amount());
    orderItem.setQuantity(payload.quantity());
    orderItem.setProductId(UUID.fromString(payload.productId()));
    orderItem = orderItemRepository.save(orderItem);
    return OrderItemResponse.toResponse(orderItem);
  }

  @Override
  public void delete(BigInteger id) throws Exception {
    getId(id);
    orderItemRepository.deleteById(id);
  }

  @Override
  public List<OrderItem> saveAll(List<OrderItemPayload> payloads) throws Exception {
    return orderItemRepository.saveAll(payloads.stream().map(payload -> {
      OrderItem orderItem = payload.toEntity();
      orderItem.setStatus(OrderItemStatus.PENDING);
      return orderItem;
    }).toList());
  }

  private OrderItem getId(BigInteger id) throws Exception {
    return orderItemRepository.findById(id)
        .orElseThrow(() -> new OrderItemNotFoundException("OI001", id + " is not available!!"));
  }
}
