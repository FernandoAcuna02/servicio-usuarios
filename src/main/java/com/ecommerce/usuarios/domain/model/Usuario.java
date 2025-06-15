package com.ecommerce.usuarios.domain.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password; // En un proyecto real, esto estaría encriptado.
    private LocalDateTime fechaCreacion;
}