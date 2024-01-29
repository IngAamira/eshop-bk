package com.ingaamira.infrastructure.mapper;

import com.ingaamira.domain.model.Category;
import com.ingaamira.infrastructure.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Mapper que realiza la conversión entre objetos de tipo Category y CategoryEntity.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /**
     * Instancia del CategoryMapper.
     */
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    /**
     * Convierte una entidad de categoría a un objeto de dominio Category.
     *
     * @param categoryEntity La entidad de categoría a ser convertida.
     * @return Un objeto de dominio de tipo Category.
     */
    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "active", target = "active")
    })
    Category toCategory(CategoryEntity categoryEntity);

    /**
     * Convierte un objeto de dominio Category a una entidad de categoría.
     *
     * @param category El objeto de dominio Category a ser convertido.
     * @return Una entidad de categoría de tipo CategoryEntity.
     */
    CategoryEntity toCategoryEntity(Category category);

}
