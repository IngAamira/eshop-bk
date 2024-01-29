package com.ingaamira.application.services;

import com.ingaamira.application.exceptions.InvalidProductDataException;
import com.ingaamira.application.exceptions.ProductNotFoundException;
import com.ingaamira.domain.model.Product;
import com.ingaamira.infrastructure.adapter.ProductReactiveRepository;
import com.ingaamira.infrastructure.entity.ProductEntity;
import com.ingaamira.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio que gestiona operaciones relacionadas con los productos.
 */
@Service
public class ProductServices {

    private final ProductReactiveRepository productReactiveRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServices(ProductReactiveRepository productReactiveRepository, ProductMapper productMapper) {
        this.productReactiveRepository = productReactiveRepository;
        this.productMapper = productMapper;
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param productId El ID del producto a buscar.
     * @return Un Mono que emite el producto encontrado, o vacío si no se encuentra.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    public Mono<Product> getProductById(Integer productId) {
        return productReactiveRepository.findById(productId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException(productId)))
                .map(productMapper::toProduct);
    }

    /**
     * Obtiene todos los productos disponibles con paginación y filtrado opcional.
     *
     * @param page     El número de página.
     * @param size     El tamaño de página.
     * @param filterBy Una cadena para filtrar por nombre de producto (opcional).
     * @return Un Flux que emite una secuencia de productos disponibles.
     */
    public Flux<Product> getAllProducts(int page, int size, String filterBy) {
        Pageable pageable = PageRequest.of(page, size);
        return productReactiveRepository.findAllByNameContaining(filterBy, pageable)
                .map(productMapper::toProduct);
    }

    /**
     * Crea un nuevo producto.
     *
     * @param productEntity Los detalles del producto a crear.
     * @return Un Mono que emite el producto creado.
     * @throws InvalidProductDataException Si los datos del producto son inválidos.
     */
    public Mono<Product> createProduct(ProductEntity productEntity) {
        if (productEntity.getName() == null || productEntity.getName().isEmpty()) {
            throw new InvalidProductDataException("Product name cannot be empty");
        }
        return productReactiveRepository.save(productEntity)
                .map(productMapper::toProduct);
    }

    /**
     * Actualiza un producto existente por su ID.
     *
     * @param productId     El ID del producto a actualizar.
     * @param productEntity Los nuevos detalles del producto.
     * @return Un Mono que emite el producto actualizado.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    public Mono<Product> updateProduct(Integer productId, ProductEntity productEntity) {
        return productReactiveRepository.findById(productId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException(productId)))
                .flatMap(existingProduct -> {
                    existingProduct.setName(productEntity.getName());
                    existingProduct.setPrice(productEntity.getPrice());
                    return productReactiveRepository.save(existingProduct);
                })
                .map(productMapper::toProduct);
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param productId El ID del producto a eliminar.
     * @return Un Mono que se completa una vez que se ha eliminado el producto.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    public Mono<Void> deleteProduct(Integer productId) {
        return productReactiveRepository.findById(productId)
                .switchIfEmpty(Mono.error(new ProductNotFoundException(productId)))
                .flatMap(existingProduct -> productReactiveRepository.deleteById(productId));
    }

    /**
     * Obtiene productos por su categoría.
     *
     * @param categoryId El ID de la categoría de productos.
     * @return Un Flux que emite productos pertenecientes a la categoría especificada.
     */
    public Flux<Product> getProductsByCategoryId(Integer categoryId) {
        return productReactiveRepository.findByCategoryId(categoryId)
                .map(productMapper::toProduct);
    }

}
