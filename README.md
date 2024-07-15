# Proyecto Spring Gutendex Client
Este proyecto forma parte de los Challenges de ALURA LATAM
Este proyecto utiliza Spring Boot para construir una aplicación de consola que interactúa con la API Gutendex para gestionar información de libros y autores. A continuación se detallan los objetivos, logros y cómo usar la aplicación.

## Objetivos

1. **Integración con API Gutendex**: Consumir la API Gutendex para obtener información sobre libros y autores.
   
2. **Persistencia de Datos**: Utilizar PostgreSQL con Spring Data JPA para almacenar y gestionar información de libros y autores en una base de datos.

3. **Funcionalidades Principales**:
   - Búsqueda de libros por título.
   - Lista de todos los libros almacenados.
   - Lista de autores y autores vivos en un año específico.
   - Estadísticas sobre la cantidad de libros en un determinado idioma.

4. **Interacción con el Usuario**: Implementar una interfaz de consola que permita al usuario interactuar con las funcionalidades mencionadas.

5. **Pruebas y Validación**: Realizar pruebas exhaustivas para garantizar el correcto funcionamiento de todas las funcionalidades implementadas.

## Logros

1. **Configuración de Proyecto**:
   - Uso de Spring Boot 3.2.3 con Java 17.
   - Configuración de Maven para gestión de dependencias.

2. **Integración con API Gutendex**:
   - Implementación de clases `HttpClient` y `HttpRequest` para realizar solicitudes a la API y manejar respuestas JSON con Jackson.

3. **Persistencia de Datos**:
   - Creación de entidades `Book` y `Author` con anotaciones JPA para mapear objetos Java a tablas de base de datos.
   - Uso de Spring Data JPA con repositorios para realizar operaciones CRUD en la base de datos PostgreSQL.

4. **Interfaz de Consola**:
   - Implementación de la interfaz `CommandLineRunner` para interactuar con el usuario a través de la consola.
   - Menús interactivos para seleccionar opciones de búsqueda y visualización de datos.

5. **Pruebas y Validación**:
   - Pruebas unitarias y de integración para verificar el funcionamiento correcto de los servicios y repositorios.
   - Simulación de diferentes escenarios para manejar errores y casos límite.

## CREADO POR
## DAVID ALMAZAN MOYA

### Requisitos Previos

- Java 17 instalado.
- PostgreSQL instalado y configurado con una base de datos `gutendex`.