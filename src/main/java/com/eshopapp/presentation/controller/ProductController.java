package com.eshopapp.presentation.controller;

import com.eshopapp.application.services.ProductServices;
import com.eshopapp.domain.model.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
     * Obtiene todos los productos disponibles.
     *
     * @return Un Flux que emite una secuencia de productos disponibles.
     */
    @GetMapping("/all")
    public Flux<Product> getAllProducts() {
        return productServices.getAllProducts();
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

}
