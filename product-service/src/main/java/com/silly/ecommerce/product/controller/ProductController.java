package com.silly.ecommerce.product.controller;

import com.silly.ecommerce.common.response.ResultResponse;
import com.silly.ecommerce.product.dto.request.ProductRequestDto;
import com.silly.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.silly.ecommerce.common.constants.ResponseStatusEnum.CREATED;
import static com.silly.ecommerce.common.constants.ResponseStatusEnum.UPDATED;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResultResponse> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.create(productRequestDto);
        return ResponseEntity.ok(ResultResponse.of(CREATED));
    }

    @PutMapping
    public ResponseEntity<ResultResponse> updateProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.update(productRequestDto);
        return ResponseEntity.ok(ResultResponse.of(UPDATED));
    }
}
