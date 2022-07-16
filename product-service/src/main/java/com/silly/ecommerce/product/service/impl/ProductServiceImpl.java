package com.silly.ecommerce.product.service.impl;

import com.silly.ecommerce.common.exception.SeException;
import com.silly.ecommerce.common.response.ResultResponse;
import com.silly.ecommerce.product.dto.request.ProductRequestDto;
import com.silly.ecommerce.product.dto.response.ProductResponseDto;
import com.silly.ecommerce.product.entity.Product;
import com.silly.ecommerce.product.entity.Variant;
import com.silly.ecommerce.product.repository.ProductRepository;
import com.silly.ecommerce.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public void create(ProductRequestDto requestDto) {
        Product product = new Product();
        BeanUtils.copyProperties(requestDto, product);

        Variant variant = new Variant();
        variant.setVariantName("test");
        variant.setProduct(product);

        List<Variant> variants = new ArrayList<>();
        variants.add(variant);

        product.setVariants(variants);
        productRepository.save(product);
    }

    @Override
    public void update(ProductRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getId()).
                orElseThrow(() -> new SeException(ResultResponse.STATUS_BAD_REQUEST, "not found"));
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductResponseDto> findAll() {
        return null;
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return null;
    }
}
