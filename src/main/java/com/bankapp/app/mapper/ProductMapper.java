package com.bankapp.app.mapper;

import com.bankapp.app.entity.Product;
import com.bankapp.app.entity.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

}
