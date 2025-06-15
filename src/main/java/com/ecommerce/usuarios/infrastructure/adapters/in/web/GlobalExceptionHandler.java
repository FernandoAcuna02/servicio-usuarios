package com.ecommerce.usuarios.infrastructure.adapters.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        // Creamos un cuerpo de respuesta JSON para el error
        Map<String, Object> body = Map.of(
            "error", "Conflicto de Datos",
            "mensaje", ex.getMessage(),
            "status", HttpStatus.CONFLICT.value()
        );
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}