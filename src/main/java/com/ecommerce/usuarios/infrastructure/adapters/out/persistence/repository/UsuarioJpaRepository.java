package com.ecommerce.usuarios.infrastructure.adapters.out.persistence.repository;

import com.ecommerce.usuarios.infrastructure.adapters.out.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {

    // Spring creará la consulta para buscar un usuario por su email
    Optional<UsuarioEntity> findByEmail(String email);
}