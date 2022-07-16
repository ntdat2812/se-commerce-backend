package com.silly.ecommerce.order.service.impl;

import com.silly.ecommerce.order.dto.request.OrderRequestDto;
import com.silly.ecommerce.order.dto.response.OrderResponseDto;
import com.silly.ecommerce.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public void create(OrderRequestDto requestDto) {

    }

    @Override
    public void update(OrderRequestDto requestDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<OrderResponseDto> findAll() {
        return null;
    }

    @Override
    public OrderResponseDto findById(Long id) {
        return null;
    }
}
