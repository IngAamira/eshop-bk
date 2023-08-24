package com.eshopapp.infrastructure.mapper;

import com.eshopapp.domain.model.Category;
import com.eshopapp.domain.model.Product;
import com.eshopapp.infrastructure.entity.CategoryEntity;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapper que realiza la conversión entre objetos de tipo Product y ProductEntity.
 */
@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    /**
     * Instancia del ProductMapper.
     */
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    /**
     * Convierte una entidad de producto a un objeto de dominio Product.
     *
     * @param productEntity La entidad de producto a ser convertida.
     * @return Un objeto de dominio de tipo Product.
     */
    @Mappings(
            value = {
                    @Mapping(source = "productId", target = "productId"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "brand", target = "brand"),
                    @Mapping(source = "gender", target = "gender"),
                    @Mapping(source = "active", target = "active")
            }
    )
    Product toProduct(ProductEntity productEntity);

    /**
     * Convierte un objeto de dominio Product a una entidad de producto.
     *
     * @param product El objeto de dominio Product a ser convertido.
     * @return Una entidad de producto de tipo ProductEntity.
     */
    ProductEntity toProductEntity(Product product);

    /**
     * Convierte una entidad de categoría a un objeto de dominio Category.
     *
     * @param categoryEntity La entidad de categoría a ser convertida.
     * @return Un objeto de dominio de tipo Category.
     */
    Category toCategory(CategoryEntity categoryEntity);

    /**
     * Convierte un objeto de dominio Category a una entidad de categoría.
     *
     * @param category El objeto de dominio Category a ser convertido.
     * @return Una entidad de categoría de tipo CategoryEntity.
     */
    CategoryEntity toCategoryEntity(Category category);

    /**
     * Mapea una entidad de producto a su correspondiente objeto de dominio Product.
     *
     * @param productEntity La entidad de producto a ser mapeada.
     * @return Un objeto de dominio de tipo Product mapeado desde la entidad.
     * @deprecated Este método está en desuso y se reemplaza por toProduct(ProductEntity productEntity).
     */
    @Deprecated
    Product mapEntityToDomain(ProductEntity productEntity);

}
