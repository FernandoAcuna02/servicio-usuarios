package com.ecommerce.usuarios.infrastructure.adapters.in.web.dto;

public record UsuarioRequest(
    String nombre,
    String apellido,
    String email,
    String password
) {}