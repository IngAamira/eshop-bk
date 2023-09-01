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

- `com.eshopapp.application.exceptions`: Contiene las clases de excepción personalizadas como `InvalidProductDataException` y `ProductNotFoundException`.
- `com.eshopapp.application.repository`: Contiene interfaces para acceder a los datos de productos y categorías.
- `com.eshopapp.application.services`: Contiene los servicios de la aplicación para manejar la lógica de negocio.
- `com.eshopapp.domain.model`: Contiene las clases de dominio como `Product`, `Category` y `Gender`.
- `com.eshopapp.infrastructure.adapter`: Contiene adaptadores para interactuar con la capa de infraestructura y bases de datos.
- `com.eshopapp.infrastructure.entity`: Contiene las entidades JPA que representan productos y categorías en la base de datos.
- `com.eshopapp.infrastructure.mapper`: Contiene los mappers que convierten entre entidades y objetos de dominio.
- `com.eshopapp.presentation.controller`: Contiene los controladores que manejan las peticiones HTTP y gestionan la API.

### Manejo de Excepciones

- `com.eshopapp.application.exceptions.InvalidProductDataException`: Excepción lanzada cuando se encuentran datos de producto no válidos al crear o actualizar un producto.
- `com.eshopapp.application.exceptions.ProductNotFoundException`: Excepción lanzada cuando no se encuentra un producto con el ID especificado.

### Implementación de Paginación y Filtrado

La implementación de paginación y filtrado en los endpoints de listado se realiza utilizando Spring Data R2DBC.
El método getAllProducts acepta parámetros de paginación (page y size), ordenamiento (sortBy) y filtrado (filterBy). Estos parámetros se utilizan para realizar la búsqueda paginada y filtrada de productos en función de las necesidades del cliente.

### Uso de Tecnologías

- Spring Boot: Framework para la construcción de aplicaciones Java.
- Spring Data R2DBC: Para el acceso a bases de datos reactivas.
- MapStruct: Para la conversión eficiente entre entidades y objetos de dominio.
- Reactor: Biblioteca para programación reactiva.
- Lombok: Para la generación de código repetitivo.
- Markdown: Para la documentación del proyecto.


## Documentación de Endpoints:

### Obtener todos los productos (getAllProducts)

- **Descripción:** Este endpoint te permite obtener una lista paginada de todos los productos disponibles.

- **Método HTTP:** GET

- **Ruta:** `/all`

- **Parámetros de consulta:**
    - `page` (Opcional): Número de página, comenzando desde 0. Por defecto, es 0.
    - `size` (Opcional): Tamaño de la página, que determina la cantidad de productos por página. Por defecto, es 5.
    - `filterBy` (Opcional): Filtrar los productos por nombre. Por defecto, se aplica ningún filtro.

- **Respuesta Exitosa (200 OK):**
    - Tipo: Flux de Product
    - Descripción: Una secuencia de productos disponibles según los parámetros de paginación y filtro.

- **Ejemplo de Solicitud:**
    ```http
    GET /all?page=0&size=10&filterBy=Laptop
    ```

### Obtener un producto por ID (getProductById)

- **Descripción:** Este endpoint te permite obtener un producto por su ID.

- **Método HTTP:** GET

- **Ruta:** `/{productId}`

- **Parámetros de ruta:**
    - `productId` (Requerido): El ID del producto que deseas obtener.

- **Respuesta Exitosa (200 OK):**
    - Tipo: Mono de Product
    - Descripción: El producto encontrado con el ID especificado.

- **Respuesta No Encontrada (404 Not Found):**
    - Tipo: Vacío (Mono&lt;Void&gt;)
    - Descripción: Si el producto no se encuentra.

- **Ejemplo de Solicitud:**
    ```http
    GET /123
    ```

### Crear un nuevo producto (createProduct)

- **Descripción:** Este endpoint te permite crear un nuevo producto.

- **Método HTTP:** POST

- **Ruta:** `/`

- **Cuerpo de la Solicitud:**
    - Tipo: JSON
    - Descripción: Los detalles del producto que deseas crear.

- **Respuesta Exitosa (201 Created):**
    - Tipo: Mono de Product
    - Descripción: El producto creado.

- **Ejemplo de Solicitud:**
    ```http
    POST /
    {
        "name": "Laptop Dell XPS 15",
        "price": 1399.99,
        "brand": "Dell",
        "gender": "MALE",
        "categoryId": 5
    }
    ```

### Actualizar un producto existente por ID (updateProduct)

- **Descripción:** Este endpoint te permite actualizar un producto existente por su ID.

- **Método HTTP:** PUT

- **Ruta:** `/{productId}`

- **Parámetros de ruta:**
    - `productId` (Requerido): El ID del producto que deseas actualizar.

- **Cuerpo de la Solicitud:**
    - Tipo: JSON
    - Descripción: Los nuevos detalles del producto.

- **Respuesta Exitosa (200 OK):**
    - Tipo: Mono de Product
    - Descripción: El producto actualizado.

- **Respuesta No Encontrada (404 Not Found):**
    - Tipo: Vacío (Mono&lt;Void&gt;)
    - Descripción: Si el producto no se encuentra.

- **Ejemplo de Solicitud:**
    ```http
    PUT /123
    {
        "name": "Laptop Dell XPS 15 (Actualizado)",
        "price": 1499.99,
        "brand": "Dell",
        "gender": "MALE",
        "categoryId": 5
    }
    ```

### Eliminar un producto por ID (deleteProduct)

- **Descripción:** Este endpoint te permite eliminar un producto por su ID.

- **Método HTTP:** DELETE

- **Ruta:** `/{productId}`

- **Parámetros de ruta:**
    - `productId` (Requerido): El ID del producto que deseas eliminar.

- **Respuesta Exitosa (204 No Content):**
    - Tipo: Vacío (Mono&lt;Void&gt;)
    - Descripción: Se completa una vez que se ha eliminado el producto.

- **Ejemplo de Solicitud:**
    ```http
    DELETE /123
    ```

### Obtener productos por categoría (getProductsByCategoryId)

- **Descripción:** Este endpoint te permite obtener una lista de productos por su categoría.

- **Método HTTP:** GET

- **Ruta:** `/byCategory/{categoryId}`

- **Parámetros de ruta:**
    - `categoryId` (Requerido): El ID de la categoría de productos que deseas obtener.

- **Respuesta Exitosa (200 OK):**
    - Tipo: Flux de Product
    - Descripción: Una secuencia de productos pertenecientes a la categoría especificada.

- **Ejemplo de Solicitud:**
    ```http
    GET /byCategory/5
    ```

### Manejar Excepciones de Validación (handleValidationExceptions)

- **Descripción:** Este es un controlador para manejar excepciones de validación arrojadas por Spring durante la validación de entrada.

- **Método HTTP:** No aplica

- **Respuesta Exitosa (400 Bad Request):**
    - Tipo: Mapa de campos con errores y mensajes de error
    - Descripción: Un mapa que contiene los campos con errores de validación y sus respectivos mensajes de error.


## Configuración Aplicación

- La configuración de la aplicación se encuentra en archivos `application.properties` y `application.yml`.
- La base de datos y otras configuraciones se pueden ajustar según las necesidades del entorno.

## Instalación y Uso

1. Clona el repositorio.
2. Importa el proyecto en tu IDE favorito como proyecto Maven.
3. Ajusta la configuración de la base de datos y otras propiedades en `application.properties` o `application.yml`.
4. Ejecuta la aplicación desde tu IDE o mediante `mvn spring-boot:run`.

## Colaboradores

- Manuel Cuevas: Líder Técnico
- Andrés Alfonso Mira Mejía (@IngAamira): Desarrollador de Software