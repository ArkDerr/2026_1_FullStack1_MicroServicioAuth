# MicroServicio Login - JWT + Spring Security + Flyway + MySQL

Microservicio de autenticación desarrollado con Spring Boot utilizando:

- Spring Security
- JWT (JSON Web Token)
- MySQL
- Flyway
- Spring Data JPA
- Arquitectura Stateless

---

# Objetivo del Proyecto

Este microservicio permite:

- Validar credenciales de usuario
- Generar tokens JWT
- Implementar autenticación Stateless
- Proteger APIs REST utilizando Spring Security
- Gestionar migraciones SQL con Flyway

---

# Tecnologías Utilizadas

| Tecnología      | Descripción               |
| --------------- | ------------------------- |
| Spring Boot     | Framework principal       |
| Spring Security | Seguridad y autenticación |
| JWT             | Tokens de autenticación   |
| Spring Data JPA | Persistencia              |
| Hibernate       | ORM                       |
| MySQL           | Base de datos             |
| Flyway          | Migraciones SQL           |
| Lombok          | Reducción de boilerplate  |
| Maven           | Gestión de dependencias   |

---

# Dependencias Agregadas desde start.spring.io

Al crear el proyecto en:

```text
https://start.spring.io
```

se agregaron las siguientes dependencias desde la interfaz gráfica:

- Spring Web
- Spring Security
- Validation
- Spring Data JPA
- MySQL Driver
- Flyway Migration
- Lombok
- Spring Boot DevTools

## Spring Web

Permite:

- Crear APIs REST
- Utilizar `@RestController`
- Utilizar `@GetMapping`, `@PostMapping`
- JSON automático
- Tomcat embebido

---

## Spring Security

Permite:

- Autenticación
- Autorización
- Filtros de seguridad
- Integración JWT
- `SecurityFilterChain`

---

## Validation

Permite:

- Validar DTOs
- `@Valid`
- `@NotBlank`
- `@NotNull`

---

## Spring Data JPA

Permite:

- Persistencia ORM
- Repositories
- Hibernate
- Entidades JPA

---

## MySQL Driver

Driver JDBC para conectarse a MySQL.

---

## Flyway Migration

Permite:

- Ejecutar migraciones SQL automáticamente
- Versionar scripts SQL
- Crear tablas automáticamente

---

## Lombok

Permite:

- Reducir código repetitivo
- Generar getters/setters automáticamente
- Generar constructores automáticamente

---

## Spring Boot DevTools

Permite:

- Reinicio automático
- Hot reload
- Mejor experiencia de desarrollo

---

# Dependencias Agregadas Manualmente

Las siguientes dependencias se agregaron manualmente al `pom.xml`.

---

## JWT

```xml
<dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>4.4.0</version>
</dependency>
```

### ¿Qué hace?

Permite:

- Crear JWT
- Firmar JWT
- Validar JWT
- Leer Claims
- Verificar expiración

---

## Spring Boot Configuration Processor

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

### ¿Qué hace?

Permite:

- Metadata Spring
- Autocompletado en VS Code
- Validación de properties
- Reconocimiento de:

```properties
jwt.secret
jwt.expiration
```

---

# Arquitectura Stateless

Este proyecto utiliza autenticación Stateless.

Esto significa:

- El servidor NO guarda sesiones HTTP
- Cada request debe enviar el JWT
- El cliente se autentica una vez
- Luego reutiliza el token

Configuración utilizada:

```java
.sessionManagement(session ->
    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
)
```

---

# Flujo JWT

## 1. Login

Cliente:

```http
POST /api/v1/auth/login
```

Body:

```json
{
  "username": "admin",
  "password": "1234"
}
```

---

## 2. Validación

El sistema:

- Busca usuario en MySQL
- Valida password
- Genera JWT

---

## 3. Respuesta

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## 4. Consumo de APIs protegidas

El cliente debe enviar:

```http
Authorization: Bearer TOKEN
```

---

# Configuración Flyway

## Ruta de migraciones

```properties
spring.flyway.locations=classpath:bd/migration
```

---

## Estructura

```text
src/main/resources/bd/migration
```

---

## Scripts

### V1\_\_crear_tabla_usuario.sql

Crea:

- tabla usuario

---

### V2\_\_insertar_usuarios_demo.sql

Inserta:

- admin
- usuario

---

# Configuración Base de Datos

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_usuario
spring.datasource.username=usuario
spring.datasource.password=pass123
```

---

# Configuración JWT

```properties
jwt.secret=clave-super-secreta-para-clase-123456
jwt.expiration=3600000
```

---

# Estructura Principal del Proyecto

```text
controller
 └── AuthController

service
 ├── AuthService
 └── JwtService

security
 └── SecurityConfig

repository
 └── UsuarioRepository

model
 └── UsuarioModel

dto
 ├── request
 └── response

configuration
 └── JwtProperties
```

---

# Endpoint Principal

## Login

```http
POST /api/v1/auth/login
```

Body:

```json
{
  "username": "admin",
  "password": "1234"
}
```

---

# Usuarios de Prueba

| Username | Password | Rol   |
| -------- | -------- | ----- |
| admin    | 1234     | ADMIN |
| usuario  | 1234     | USER  |

---

# Seguridad Implementada

## Spring Security

- Protección de endpoints
- Filtros HTTP
- Arquitectura Stateless

---

## JWT

- Firma HMAC256
- Claims
- Expiración
- Bearer Token

---

# Conceptos Implementados

- REST API
- DTO
- JPA
- Hibernate
- Flyway
- JWT
- Spring Security
- Stateless Authentication
- Dependency Injection
- Repository Pattern
- Service Layer
- Bean Validation

---

# Autor

Proyecto académico desarrollado para aprendizaje de:

- Spring Security
- JWT
- Microservicios
- Seguridad REST
- Flyway
- Arquitectura Stateless
