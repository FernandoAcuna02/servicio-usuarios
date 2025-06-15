# Microservicio: Servicio de Usuarios

Este repositorio contiene el código fuente del `servicio-usuarios`, que forma parte de un sistema de E-Commerce basado en una arquitectura de microservicios.

## Descripción

Este microservicio es el responsable de toda la gestión de usuarios y clientes. Sus responsabilidades incluyen el registro de nuevos usuarios, la consulta de su información y la gestión de sus datos personales. Funciona de manera autónoma y expone sus funcionalidades a través de una API REST segura.

## Arquitectura y Diseño

El desarrollo de este microservicio se adhiere a principios de diseño de software modernos para garantizar su mantenibilidad, escalabilidad y testabilidad.

-   **Arquitectura de Microservicios:** El servicio está diseñado para ser una unidad de despliegue independiente, gestionando su propio dominio y su propia base de datos.
-   **Arquitectura Hexagonal (Puertos y Adaptadores):** Se ha implementado esta arquitectura para aislar completamente el núcleo de la lógica de negocio (dominio) de las tecnologías externas (infraestructura).
-   **Principios SOLID:** El código sigue los principios SOLID para crear un software robusto y fácil de mantener.

## Tecnologías Utilizadas

-   **Lenguaje:** Java 17
-   **Framework:** Spring Boot 3.x
-   **Persistencia:** Spring Data JPA / Hibernate
-   **Base de Datos:** PostgreSQL
-   **Gestión de Dependencias:** Maven

## Endpoints de la API

La API se expone en la ruta base `/api/usuarios`.

---

### Crear un nuevo usuario

-   **Método:** `POST`
-   **URL:** `/api/usuarios`
-   **Descripción:** Permite registrar un nuevo usuario en el sistema.
-   **Request Body (Ejemplo):**
    ```json
    {
        "nombre": "Ana",
        "apellido": "García",
        "email": "ana.garcia@example.com",
        "password": "password123"
    }
    ```
-   **Respuesta Exitosa (201 Created):**
    ```json
    {
        "id": 1,
        "nombre": "Ana",
        "apellido": "García",
        "email": "ana.garcia@example.com",
        "password": null,
        "fechaCreacion": "2025-06-14T20:02:00"
    }
    ```

---

### Obtener un usuario por su ID

-   **Método:** `GET`
-   **URL:** `/api/usuarios/{id}`
-   **Descripción:** Devuelve los detalles de un usuario específico.
-   **Respuesta Exitosa (200 OK):**
    ```json
    {
        "id": 1,
        "nombre": "Ana",
        "apellido": "García",
        "email": "ana.garcia@example.com",
        "password": null,
        "fechaCreacion": "2025-06-14T20:02:00"
    }
    ```
Autor
(CIPALOSINGENIEROS)
  
