# 🚀 Spring Security JWT

Aplicación desarrollada con enfoque en seguridad, que implementa un sistema de autenticación y autorización utilizando
JWT (JSON Web Tokens). Proporciona endpoints para el registro de usuarios, autenticación mediante credenciales y
renovación de tokens, siguiendo un modelo stateless que mejora la escalabilidad y seguridad de la API.

### 📝 Notas

Este proyecto toma como referencia el tutorial https://youtu.be/-Z4a0bKr2Pg
y ha sido extendido con mejoras arquitectónicas, optimización de configuración y la incorporación de buenas prácticas
basadas en experiencia profesional en el desarrollo de APIs seguras con Spring Boot y JWT.

## 📦 Arquitectura del Proyecto

Este proyecto está basado en una arquitectura en capas utilizando Spring Boot, orientada a escalabilidad, mantenibilidad
y testabilidad.

## 🧩 Estructura

|     📂      | Descripción                                                         |
|:-----------:|---------------------------------------------------------------------|
| controller  | Maneja las solicitudes HTTP (REST endpoints).                       |
|    dto/     | Contiene los objetos de transferencia de datos (request / response) |
|  service/   | Contiene la lógica de negocio (service / service implementes)       |
|   domain/   | Entidades JPA que representan las tablas de la base de datos.       |
| repository/ | Acceso a datos mediante Spring Data JPA.                            |
|   config    | Configuración global del sistema.                                   |

## 🗄️ Base de Datos

Se utiliza H2 en memoria para desarrollo:

- URL: `http://localhost:9091/admin/jwt/v1/h2-console`
- User (default): `sa`
- Password (default): `password`

## 📡 Endpoints

|            Ruta             | Tipo |                              Descripción                               |
|:---------------------------:|:----:|:----------------------------------------------------------------------:|
| /admin/jwt/v1/auth/register | POST |                Se encarga de registrar a los usuarios.                 |
|  /admin/jwt/v1/auth/login   | POST |             Se encarga de realizar el logeo con el usuario             |
|  admin/jwt/v1/auth/refresh  | POST | Se encargar de generar generar un nuevo token para un usuario logeado. |
