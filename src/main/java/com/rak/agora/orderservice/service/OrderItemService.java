package com.rak.agora.orderservice.service;

import com.rak.agora.common.service.CrudService;
import com.rak.agora.orderservice.models.OrderItem;
import com.rak.agora.orderservice.payloads.OrderItemPayload;
import com.rak.agora.orderservice.response.OrderItemResponse;
import java.math.BigInteger;
import java.util.List;

public interface OrderItemService
    extends CrudService<OrderItemPayload, BigInteger, OrderItemResponse> {
  public List<OrderItem> saveAll(List<OrderItemPayload> payloads) throws Exception;
}
