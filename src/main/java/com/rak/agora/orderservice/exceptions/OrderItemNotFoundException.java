package com.rak.agora.orderservice.exceptions;

import lombok.Getter;

@Getter
public class OrderItemNotFoundException extends Exception{
  private final String errorCode;
  public OrderItemNotFoundException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

}
