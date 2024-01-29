# E-Shop Project Documentation

## Description
This is an e-commerce application developed in Java with the Spring Boot framework with Spring WebFlux. The application allows users to browse and purchase products online, organized into categories.

## Project Structure
The project follows a hexagonal architecture for a clear separation of application, domain, and infrastructure layers. It utilizes reactive programming to handle asynchronous operations.

## Folder Structure

```bash
/eshop
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.ingaamira
│   │   │   │   ├── application
│   │   │   │   │   ├── exceptions
│   │   │   │   │   ├── repository
│   │   │   │   │   ├── services
│   │   │   │   ├── domain
│   │   │   │   │   ├── model
│   │   │   │   ├── infrastructure
│   │   │   │   │   ├── adapter
│   │   │   │   │   ├── entity
│   │   │   │   │   ├── mapper
│   │   │   │   ├── presentation
│   │   │   │   │   ├── controller
│   │   ├── resources
│   │   │   ├── application.properties
│   ├── test
├── .gitignore
├── build.gradle
├── settings.gradle
├── README.md
```

## Key Components

### Classes and Packages

- `com.ingaamira.application.exceptions`: Contains custom exception classes like `InvalidProductDataException` y `ProductNotFoundException`.
- `com.ingaamira.application.repository`: Contains interfaces to access product and category data.
- `com.ingaamira.application.services`: Contains application services to handle business logic.
- `com.ingaamira.domain.model`: Contains domain classes like `Product`, `Category` y `Gender`.
- `com.ingaamira.infrastructure.adapter`: Contains adapters to interact with the infrastructure layer and databases.
- `com.ingaamira.infrastructure.entity`: Contains JPA entities representing products and categories in the database.
- `com.ingaamira.infrastructure.mapper`: Contains mappers that convert between entities and domain objects.
- `com.ingaamira.presentation.controller`: Contains controllers that handle HTTP requests and manage the API.

### Exception Handling

- `com.ingaamira.application.exceptions.InvalidProductDataException`: Exception thrown when invalid product data is encountered while creating or updating a product.
- `com.ingaamira.application.exceptions.ProductNotFoundException`: Exception thrown when a product with the specified ID is not found.

### Pagination and Filtering Implementation

- Pagination and filtering implementation in list endpoints is done using Spring Data R2DBC.
- The getAllProducts method accepts pagination (page and size), sorting (sortBy), and filtering (filterBy) parameters. These parameters are used to perform paginated and filtered search for products based on client needs.

### Technology Stack

- Spring Boot: Framework for building Java applications.
- Spring Data R2DBC: For accessing reactive databases.
- MapStruct: For efficient conversion between entities and domain objects.
- Reactor: Library for reactive programming.
- Lombok: For generating repetitive code.
- Markdown: For project documentation.

## Endpoint Documentation:

### Get all products (getAllProducts)

- **Description:** This endpoint allows you to get a paginated list of all available products.
- **HTTP Method:** GET
- **Path:** `/api/products/all`
- **Successful Response (200 OK):**
    - Type: Flux of Product
- **Example Request:**
    ```http
    GET /api/products/all
    ```

### Get a product by ID (getProductById)

- **Description:** This endpoint allows you to get a product by its ID.
- **HTTP Method:** GET
- **Path:** `api/products/{productId}`
- **Path Parameters:**
    - `productId` (Required): The ID of the product you want to retrieve.
  - **Successful Response (200 OK):**
    - Type: Mono of Product
    - Description: The product found with the specified ID.
  - **Not Found Response (404 Not Found):**
    - Type: Empty (Mono<Void>)
    - Description: If the product is not found.
- **Example Request:**
    ```http
    GET api/products/1
    ```

### Create a new product (createProduct)

- **Description:** This endpoint allows you to create a new product.
- **HTTP Method:** POST
- **Path:** `api/products`
- **Request Body:**
    - Type: JSON
    - Description: The details of the product you want to create.
- **Successful Response (201 Created):**
    - Type: Mono of Product
    - Description: The created product.
- **Example Request:**
    ```http
    POST api/products
    {
    "name": "T-Shirt",
    "price": 45.0,
    "brand": "Adidas",
    "gender": "MAN",
    "active": true,
    "categoryId": 1
    }
    ```

### Update an existing product by ID (updateProduct)

- **Description:** This endpoint allows you to update an existing product by its ID.
- **HTTP Method:** PUT
- **Path:** `api/products/{productId}`
- **Path Parameters:**
    - `productId` (Required): The ID of the product you want to update.
- **Request Body:**
    - Type: JSON
    - Description: The new details of the product.
- **Successful Response (200 OK):**
    - Type: Mono of Product
    - Description: The updated product.
- **Not Found Response (404 Not Found):**
    - Type: Mono of Product
    - Description: The updated product.
- **Example Request:**
    ```http
    PUT api/products/1
    {
    "productId": 1,
    "name": "Leggins",
    "price": 25.0,
    "brand": "Adidas",
    "gender": "MAN",
    "active": true,
    "categoryId": 1
    }
    ```

### Delete a product by ID (deleteProduct)

- **Description:** This endpoint allows you to delete a product by its ID.
- **HTTP Method:** DELETE
- **Path:** `api/products/{productId}`
- **Path Parameters:**
    - `productId`  (Required): The ID of the product you want to delete.
- **Successful Response (200 OK):**
    - Type: Empty (Mono<Void>)
    - Description: Completed once the product is deleted.
- **Example Request:**
    ```http
    DELETE api/products/1
    ```

### Get products by category (getProductsByCategoryId)

- **Description:** This endpoint allows you to get a list of products by their category.
- **HTTP Method:** GET
- **Path:** `/byCategory/{categoryId}`
- **Path Parameters:**
    - `categoryId` (Required): The ID of the product category you want to retrieve.
- **Successful Response (200 OK):**
    - Type: Flux of Product
    - Description: A sequence of products belonging to the specified category.
- **Example Request:**
    ```http
    GET /byCategory/5
    ```

### Handle Validation Exceptions (handleValidationExceptions)

- **Description:** This is a controller to handle validation exceptions thrown by Spring during input validation.
- **HTTP Method:** Not Applicable.
- **Not Found Response (404 Not Found):**
    - Type: Map of fields with errors and error messages
    - Description: A map containing validation error fields and their respective error messages.

## Application Configuration

- Application configuration is found in `application.properties`.
- Database and other configurations can be adjusted as per environment needs.

## Configuration Database Example

```sql
CREATE DATABASE eshop_rx_db
  WITH
  OWNER = postgres
  ENCODING = 'UTF8'
  LC_COLLATE = 'C.UTF-8'
  LC_CTYPE = 'C.UTF-8'
  TABLESPACE = pg_default
  CONNECTION LIMIT = -1
  IS_TEMPLATE = False;
```

```sql
CREATE TABLE categories (
  category_id SERIAL PRIMARY KEY,
  description VARCHAR(255),
  active BOOLEAN
);

INSERT INTO categories (description, active) VALUES
 ('MAN CLOTHES', true),
 ('WOMEN CLOTHES', true),
 ('BOY CLOTHES', true),
 ('GIRL CLOTHES', true),
 ('BABY CLOTHES', true),
 ('FOOTWEAR', true),
 ('ACCESSORIES', true);
```

```sql
CREATE TABLE products (
  product_id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  price DECIMAL(10, 2) NOT NULL,
  brand VARCHAR(255),
  gender VARCHAR(10),
  active BOOLEAN,
  category_id INT,
  FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

ALTER TABLE products ALTER COLUMN product_id SET DEFAULT nextval('products_product_id_seq');

SELECT setval('products_product_id_seq', (SELECT max(product_id) FROM products) + 1);

INSERT INTO products (name, price, brand, gender, active, category_id) VALUES
  ('Pants', 35.0, 'Adidas', 'MAN', true, 1),
  ('Shoes', 50.0, 'Puma', 'MAN', true, 1),
  ('T-Shirt', 20.0, 'Nike', 'WOMAN', true, 2),
  ('Dress', 45.0, 'H&M', 'WOMAN', true, 2),
  ('Blouse', 25.0, 'Zara', 'WOMAN', true, 2),
  ('Shoes', 22.0, 'Puma', 'MAN', true, 3),
  ('Pants', 32.0, 'Adidas', 'WOMAN', true, 3),
  ('Shoes', 22.6, 'Puma', 'WOMAN', true, 4),
  ('Pants', 32.6, 'Adidas', 'WOMAN', true, 4),
  ('Shoes', 22.5, 'Puma', 'MAN', true, 5),
  ('Pants', 32.5, 'Adidas', 'WOMAN', true, 5);
```

## Installation and Usage

1. Clone the repository.
2. Import the project into your favorite IDE.
3. Adjust database configuration and other properties in `application.properties`.
4. Run the application from your IDE or using `mvn spring-boot:run`.

## Contributors

- Manuel Cuevas: Technical Leader
- Andrés Alfonso Mira Mejía (@IngAamira): Software Developer