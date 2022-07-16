package com.silly.ecommerce.order.controller;

import com.silly.ecommerce.common.constants.BaseConstant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping(BaseConstant.BASE_API_V1 + "/orders")
@RestController
public class OrderController {
}
