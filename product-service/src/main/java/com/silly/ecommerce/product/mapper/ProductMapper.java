package com.silly.ecommerce.product.mapper;

import com.silly.ecommerce.common.mapper.BaseMapper;
import com.silly.ecommerce.product.dto.response.ProductResponseDto;
import com.silly.ecommerce.product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductResponseDto> {
}
