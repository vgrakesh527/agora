package com.rak.agora.productservice.messages;

public record ProductNotFoundMessage(
        int errorCode,
        String message
) {
}
