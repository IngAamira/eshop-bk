# Documentación del Proyecto E-ShopApp

## Descripción
E-ShopApp es una aplicación de comercio electrónico desarrollada en Java con el framework Spring Boot. La aplicación permite a los usuarios explorar y comprar productos en línea, organizados en categorías.

## Estructura del Proyecto
El proyecto sigue una arquitectura hexagonal para una separación clara de las capas de aplicación, dominio e infraestructura. Utiliza programación reactiva para manejar operaciones asincrónicas.

## Estructura de Carpetas

- src
    - main
        - java
            - com
                - eshopapp
                    - application
                        - repository
                        - services
                    - domain
                        - model
                    - infrastructure
                        - adapter
                        - entity
                        - mapper
                    - presentation
                        - controller


## Componentes Principales

### Clases y Paquetes

- `com.eshopapp.application.repository`: Contiene interfaces para acceder a los datos de productos y categorías.
- `com.eshopapp.application.services`: Contiene los servicios de la aplicación para manejar la lógica de negocio.
- `com.eshopapp.domain.model`: Contiene las clases de dominio como `Product`, `Category` y `Gender`.
- `com.eshopapp.infrastructure.adapter`: Contiene adaptadores para interactuar con la capa de infraestructura y bases de datos.
- `com.eshopapp.infrastructure.entity`: Contiene las entidades JPA que representan productos y categorías en la base de datos.
- `com.eshopapp.infrastructure.mapper`: Contiene los mappers que convierten entre entidades y objetos de dominio.
- `com.eshopapp.presentation.controller`: Contiene los controladores que manejan las peticiones HTTP y gestionan la API.

### Uso de Tecnologías

- Spring Boot: Framework para la construcción de aplicaciones Java.
- Spring Data R2DBC: Para el acceso a bases de datos reactivas.
- MapStruct: Para la conversión eficiente entre entidades y objetos de dominio.
- Reactor: Biblioteca para programación reactiva.
- Lombok: Para la generación de código repetitivo.
- Markdown: Para la documentación del proyecto.

## Configuración

- La configuración de la aplicación se encuentra en archivos `application.properties` y `application.yml`.
- La base de datos y otras configuraciones se pueden ajustar según las necesidades del entorno.

## Instalación y Uso

1. Clona el repositorio.
2. Importa el proyecto en tu IDE favorito como proyecto Maven.
3. Ajusta la configuración de la base de datos y otras propiedades en `application.properties` o `application.yml`.
4. Ejecuta la aplicación desde tu IDE o mediante `mvn spring-boot:run`.

## Colaboradores

- Manual Cuevas: Líder Técnico
- Andrés Alfonso Mira Mejía (@IngAamira): Desarrollador de Software

## Licencia

Este proyecto está bajo la Licencia XYZ.s


