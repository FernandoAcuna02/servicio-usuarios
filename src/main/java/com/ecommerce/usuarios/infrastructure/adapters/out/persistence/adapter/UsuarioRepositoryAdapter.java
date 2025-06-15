package com.ecommerce.usuarios.infrastructure.adapters.out.persistence.adapter;

import com.ecommerce.usuarios.domain.model.Usuario;
import com.ecommerce.usuarios.domain.port.out.UsuarioRepositoryPort;
import com.ecommerce.usuarios.infrastructure.adapters.out.persistence.entity.UsuarioEntity;
import com.ecommerce.usuarios.infrastructure.adapters.out.persistence.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }
    
    // Mapeadores
    private UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombre());
        entity.setApellido(usuario.getApellido());
        entity.setEmail(usuario.getEmail());
        entity.setPassword(usuario.getPassword());
        entity.setFechaCreacion(usuario.getFechaCreacion());
        return entity;
    }

    private Usuario toDomainModel(UsuarioEntity entity) {
        Usuario usuario = new Usuario();
        usuario.setId(entity.getId());
        usuario.setNombre(entity.getNombre());
        usuario.setApellido(entity.getApellido());
        usuario.setEmail(entity.getEmail());
        // Por seguridad, no devolvemos la contraseña en el modelo de dominio
        usuario.setPassword(null); 
        usuario.setFechaCreacion(entity.getFechaCreacion());
        return usuario;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = toEntity(usuario);
        UsuarioEntity savedEntity = usuarioJpaRepository.save(usuarioEntity);
        return toDomainModel(savedEntity);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioJpaRepository.findById(id).map(this::toDomainModel);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioJpaRepository.findByEmail(email).map(this::toDomainModel);
    }
}