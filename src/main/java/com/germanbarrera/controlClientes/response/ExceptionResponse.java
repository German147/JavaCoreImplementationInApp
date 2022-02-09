package com.germanbarrera.controlClientes.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
