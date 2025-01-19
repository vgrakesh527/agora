package com.rak.agora.orderservice.exceptions;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends Exception{
  private final String errorCode;
  public OrderNotFoundException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
