package com.silly.ecommerce.order.service;

import com.silly.ecommerce.common.service.CrudService;
import com.silly.ecommerce.order.dto.request.OrderRequestDto;
import com.silly.ecommerce.order.dto.response.OrderResponseDto;

public interface OrderService extends CrudService<OrderRequestDto, OrderResponseDto> {
}
