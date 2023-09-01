package com.eshopapp.application.exceptions;

/**
 * Excepción lanzada cuando se detectan datos de producto inválidos.
 * Esto puede ocurrir debido a problemas de validación de datos de entrada.
 */
public class InvalidProductDataException extends RuntimeException {

    /**
     * Crea una nueva instancia de InvalidProductDataException con el mensaje de error especificado.
     *
     * @param message El mensaje de error que describe la razón de la excepción.
     */
    public InvalidProductDataException(String message) {
        super(message);
    }
}
