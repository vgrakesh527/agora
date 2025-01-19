package com.rak.agora.orderservice.controller;

import com.rak.agora.orderservice.payloads.OrderPayload;
import com.rak.agora.orderservice.response.OrderResponse;
import com.rak.agora.orderservice.service.OrderService;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderResponse>> getAllOrders() {
    return ResponseEntity.ok(orderService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponse> getOrderById(@PathVariable BigInteger id) throws
      Exception {
    return new ResponseEntity<>(orderService.getById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<OrderResponse> create(@RequestBody OrderPayload payload) throws Exception {
    return new ResponseEntity<>(orderService.create(payload), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<OrderResponse> update(@PathVariable BigInteger id,
                                              @RequestBody OrderPayload payload)
      throws Exception {
    return ResponseEntity.ok(orderService.update(id, payload));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable BigInteger id) throws Exception {
    orderService.delete(id);
    return ResponseEntity.noContent().build();
  }
}