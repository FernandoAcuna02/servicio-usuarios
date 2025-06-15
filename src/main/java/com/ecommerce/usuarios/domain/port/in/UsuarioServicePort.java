package com.ecommerce.usuarios.domain.port.in;

import com.ecommerce.usuarios.domain.model.Usuario;
import java.util.Optional;

public interface UsuarioServicePort {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Long id);
}