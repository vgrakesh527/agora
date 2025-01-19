package com.rak.agora.orderservice.controller;

import com.rak.agora.orderservice.payloads.OrderItemPayload;
import com.rak.agora.orderservice.response.OrderItemResponse;
import com.rak.agora.orderservice.service.OrderItemService;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/order-items")
public class OrderItemController {

  private final OrderItemService orderItemService;

  @GetMapping
  public ResponseEntity<List<OrderItemResponse>> getAllOrderItems() {
    return ResponseEntity.ok(orderItemService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderItemResponse> getOrderItemById(@PathVariable BigInteger id) throws
      Exception {
    return new ResponseEntity<>(orderItemService.getById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<OrderItemResponse> create(@RequestBody OrderItemPayload payload)
      throws Exception {
    return new ResponseEntity<>(orderItemService.create(payload), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<OrderItemResponse> update(@PathVariable BigInteger id,
                                                  @RequestBody OrderItemPayload payload)
      throws Exception {
    return ResponseEntity.ok(orderItemService.update(id, payload));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable BigInteger id) throws Exception {
    orderItemService.delete(id);
    return ResponseEntity.noContent().build();
  }
}