package com.rak.agora.orderservice.service;

import com.rak.agora.common.service.CrudService;
import com.rak.agora.orderservice.payloads.OrderPayload;
import com.rak.agora.orderservice.response.OrderResponse;
import java.math.BigInteger;

public interface OrderService extends CrudService<OrderPayload, BigInteger, OrderResponse> {
}
