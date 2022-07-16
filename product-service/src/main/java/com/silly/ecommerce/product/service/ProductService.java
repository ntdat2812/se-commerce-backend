package com.silly.ecommerce.product.service;

import com.silly.ecommerce.common.service.CrudService;
import com.silly.ecommerce.product.dto.request.ProductRequestDto;
import com.silly.ecommerce.product.dto.response.ProductResponseDto;

public interface ProductService extends CrudService<ProductRequestDto, ProductResponseDto> {
}
