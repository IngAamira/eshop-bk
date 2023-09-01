package com.eshopapp.presentation.controller;

import com.eshopapp.application.services.ProductServices;
import com.eshopapp.domain.model.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador para gestionar las operaciones relacionadas con los productos.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    /**
     * Obtiene todos los productos disponibles con paginación y filtrado.
     *
     * @param page     Número de página (comienza en 0).
     * @param size     Tamaño de la página (cantidad de elementos por página).
     * @param filterBy Valor de filtro (p. ej., nombre o cualquier otro criterio de filtro).
     * @return Un Flux que emite una secuencia de productos disponibles.
     */
    @GetMapping("/all")
    public Flux<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String filterBy
    ) {
        return productServices.getAllProducts(page, size, filterBy);
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return Un Mono que emite el producto encontrado, o vacío si no se encuentra.
     */
    @GetMapping("/{productId}")
    public Mono<Product> getProductById(@PathVariable Integer productId) {
        return productServices.getProductById(productId);
    }

    /**
     * Crea un nuevo producto.
     *
     * @param productEntity Los detalles del producto a crear.
     * @return Un Mono que emite el producto creado.
     */
    @PostMapping
    public Mono<Product> createProduct(@RequestBody ProductEntity productEntity) {
        return productServices.createProduct(productEntity);
    }

    /**
     * Actualiza un producto existente por su ID.
     *
     * @param productId     El ID del producto a actualizar.
     * @param productEntity Los nuevos detalles del producto.
     * @return Un Mono que emite el producto actualizado.
     */
    @PutMapping("/{productId}")
    public Mono<Product> updateProduct(@PathVariable Integer productId, @RequestBody ProductEntity productEntity) {
        return productServices.updateProduct(productId, productEntity);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     * @return Un Mono que se completa una vez que se ha eliminado el producto.
     */
    @DeleteMapping("/{productId}")
    public Mono<Void> deleteProduct(@PathVariable Integer productId) {
        return productServices.deleteProduct(productId);
    }

    /**
     * Obtiene productos por su categoría.
     *
     * @param categoryId El ID de la categoría de productos.
     * @return Un Flux que emite productos pertenecientes a la categoría especificada.
     */
    @GetMapping("/byCategory/{categoryId}")
    public Flux<Product> getProductsByCategoryId(@PathVariable Integer categoryId) {
        return productServices.getProductsByCategoryId(categoryId);
    }

    /**
     * Maneja las excepciones de validación arrojadas por Spring durante la validación de entrada.
     *
     * @param ex La excepción de tipo MethodArgumentNotValidException arrojada durante la validación.
     * @return Un mapa que contiene los campos con errores de validación y sus respectivos mensajes de error.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}