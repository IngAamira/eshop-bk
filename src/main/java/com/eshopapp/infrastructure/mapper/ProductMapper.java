package com.eshopapp.infrastructure.mapper;

import com.eshopapp.domain.Product;
import com.eshopapp.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings(
            value = {
                    @Mapping(source = "productId", target = "productId"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "brand", target = "brand"),
                    @Mapping(source = "gender", target = "gender"),
                    @Mapping(source = "active", target = "active")
            })
    Product toProduct(ProductEntity productEntity);
    Product mapEntityToDomain(ProductEntity productEntity);
    ProductEntity toProductEntity(Product product);

}