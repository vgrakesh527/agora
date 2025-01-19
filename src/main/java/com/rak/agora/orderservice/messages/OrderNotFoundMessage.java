package com.rak.agora.orderservice.messages;

public record OrderNotFoundMessage (
    String errorCode,
    String errorMessage
) {
}
