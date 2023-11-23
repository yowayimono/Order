package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Order;

public interface OrderService {
    Result insertOrder(Order order);

    Result selectOrderById(Long id);

    Result selectAllOrders();

    Result updateOrder(Order order);

    Result deleteOrderById(Long id);
}
