package com.ecommerce.usuarios.infrastructure.config;

import com.ecommerce.usuarios.application.usecase.UsuarioServiceImpl;
import com.ecommerce.usuarios.domain.port.in.UsuarioServicePort;
import com.ecommerce.usuarios.domain.port.out.UsuarioRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Le dice a Spring que esta clase contiene definiciones de Beans
public class ApplicationConfig {

    @Bean // Le dice a Spring que este método produce un Bean que debe gestionar
    public UsuarioServicePort usuarioServicePort(UsuarioRepositoryPort usuarioRepositoryPort) {
        // Aquí le estamos diciendo a Spring:
        // "Cuando alguien pida un 'UsuarioServicePort',
        // crea una nueva instancia de 'UsuarioServiceImpl'
        // y pásale el 'UsuarioRepositoryPort' que ya tienes gestionado".
        return new UsuarioServiceImpl(usuarioRepositoryPort);
    }
}