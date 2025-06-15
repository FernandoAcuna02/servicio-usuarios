package com.ecommerce.usuarios.application.usecase;

import com.ecommerce.usuarios.domain.model.Usuario;
import com.ecommerce.usuarios.domain.port.in.UsuarioServicePort;
import com.ecommerce.usuarios.domain.port.out.UsuarioRepositoryPort;
import java.time.LocalDateTime;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioServicePort {
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // Lógica de negocio: verificar si el email ya existe
        if (usuarioRepositoryPort.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalStateException("El email ya está registrado.");
        }
        usuario.setFechaCreacion(LocalDateTime.now());
        return usuarioRepositoryPort.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepositoryPort.findById(id);
    }
}