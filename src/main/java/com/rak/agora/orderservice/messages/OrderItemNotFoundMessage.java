package com.rak.agora.orderservice.messages;

public record OrderItemNotFoundMessage(
    String errorCode,
    String errorMessage
) {
}
