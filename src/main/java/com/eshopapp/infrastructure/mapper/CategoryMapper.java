package com.eshopapp.infrastructure.mapper;

import com.eshopapp.domain.Category;
import com.eshopapp.infrastructure.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "active", target = "active")
    })
    Category toCategory(CategoryEntity categoryEntity);

    //@Mapping(target = "products", ignore = true) // Ignorar mapeo inverso
    CategoryEntity toCategoryEntity(Category category);

}
