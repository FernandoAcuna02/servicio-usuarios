package com.ecommerce.usuarios.infrastructure.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity // Le dice a JPA que esta clase es una tabla en la BD
@Table(name = "usuarios") // Le damos el nombre a la tabla
@Data // Lombok para no escribir getters/setters
public class UsuarioEntity {

    @Id // Marca este campo como la clave primaria (ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Le dice a la BD que genere el ID automáticamente
    private Long id;

    private String nombre;
    private String apellido;

    @Column(unique = true, nullable = false) // El email debe ser único y no puede ser nulo
    private String email;

    @Column(nullable = false) // La contraseña no puede ser nula
    private String password;

    @Column(nullable = false, updatable = false) // La fecha de creación no puede ser nula ni actualizarse
    private LocalDateTime fechaCreacion;

    @PrePersist // Este método se ejecuta automáticamente antes de guardar por primera vez
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
}