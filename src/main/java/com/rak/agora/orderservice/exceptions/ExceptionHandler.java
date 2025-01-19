package com.rak.agora.orderservice.exceptions;

import com.rak.agora.orderservice.messages.OrderItemNotFoundMessage;
import com.rak.agora.orderservice.messages.OrderNotFoundMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler
  public ResponseEntity<OrderNotFoundMessage> orderNotFound(OrderNotFoundException e) {
    return new ResponseEntity<>(new OrderNotFoundMessage(e.getErrorCode(), e.getMessage()),
        HttpStatus.NOT_FOUND);
  }

  @org.springframework.web.bind.annotation.ExceptionHandler
  public ResponseEntity<OrderItemNotFoundMessage> orderItemNotFoundMessage(
      OrderItemNotFoundException e) {
    return new ResponseEntity<>(new OrderItemNotFoundMessage(e.getErrorCode(), e.getMessage()),
        HttpStatus.NOT_FOUND);
  }
}
