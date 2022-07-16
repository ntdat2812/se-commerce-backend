package com.silly.ecommerce.product.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductRequestDto {
    private Long id;

    @NotBlank
    private String code;
    private String name;
    private String description;
}
