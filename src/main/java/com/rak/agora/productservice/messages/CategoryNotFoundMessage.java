package com.rak.agora.productservice.messages;

public record CategoryNotFoundMessage(
        int errorCode,
        String message
) {
}
