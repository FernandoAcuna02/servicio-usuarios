package com.ecommerce.usuarios.domain.port.out;

import com.ecommerce.usuarios.domain.model.Usuario;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
}