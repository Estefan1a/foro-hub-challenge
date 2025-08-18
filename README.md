# 📚 Proyecto de Gestión de Tópicos

Este proyecto es una API REST desarrollada en Java con Spring Boot, que permite la gestión de tópicos.
Se diseñó como práctica para aplicar conceptos de arquitectura limpia, principios SOLID y buenas prácticas de desarrollo.

##  🚀 Características

Crear nuevos tópicos.

Consultar listado de tópicos.

Consultar un tópico por ID.

Actualizar información de un tópico.

Eliminar tópicos de la base de datos.

## 🛠️ Tecnologías utilizadas

Java 17

Spring Boot (Web, JPA, Validation)

MySQL como base de datos relacional

Lombok para reducir código repetitivo

Flyway para la gestión de migraciones de base de datos

Maven como gestor de dependencias

## 📂 Estructura del proyecto
src/main/java/com/tuusuario/proyecto
│
├── controller        -> Controladores REST
├── domain
│   ├── topico        -> Entidad, DTOs y repositorio
│   └── ...           
├── service           -> Lógica de negocio
└── ...

## 📋 Endpoints principales
🔹 Tópicos

GET /topicos → Listar todos los tópicos

GET /topicos/{id} → Obtener un tópico por ID

POST /topicos → Crear un nuevo tópico

PUT /topicos/{id} → Actualizar un tópico

DELETE /topicos/{id} → Eliminar un tópico

## 📌 Ejemplo de JSON para crear un tópico:

{
  "titulo": "Problema con Hibernate",
  "mensaje": "Tengo un error al hacer la configuración con MySQL",
  "autor": "Estefanía",
  "curso": "Spring Boot"
}

## 🗄️ Base de datos

La tabla topicos contiene los siguientes campos:

id (BIGINT, PK, autoincremental)

titulo (VARCHAR)

mensaje (VARCHAR)

autor (VARCHAR)

curso (VARCHAR)

fechaCreacion (TIMESTAMP)

## 🔧 Instalación y uso

Clonar el repositorio:

git clone https://github.com/tuusuario/proyecto-topicos.git


Configurar la base de datos en application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=tuusuario
spring.datasource.password=tucontraseña


Ejecutar migraciones con Flyway (se aplican automáticamente al iniciar el proyecto).

Levantar la aplicación:

mvn spring-boot:run

## 🧩 Futuras mejoras

Agregar el manejo de respuestas relacionadas a cada tópico.

Implementar Strategy Pattern para distintas formas de validar tópicos.

Mejorar seguridad con Spring Security y JWT.

Pruebas unitarias con JUnit 5 y Mockito.
