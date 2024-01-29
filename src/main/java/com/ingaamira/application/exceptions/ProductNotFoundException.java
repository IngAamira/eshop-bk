package com.ingaamira.application.exceptions;

/**
 * Excepción lanzada cuando se intenta acceder a un producto que no se encuentra en el sistema.
 * Esto generalmente ocurre cuando se busca un producto por su ID y no se encuentra en la base de datos.
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Crea una nueva instancia de ProductNotFoundException con el ID del producto que no se pudo encontrar.
     *
     * @param productId El ID del producto que no se pudo encontrar.
     */
    public ProductNotFoundException(Integer productId) {
        super("Product not found with ID: " + productId);
    }

}
