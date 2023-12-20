package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Order;
import com.yowayimono.order_food.vo.OrderVo;

public interface OrderUserService {
    Result selectAllProducts();
    Result selectProductsWithPagination(Long current, Long size);

    // Result purchase(OrderVo orderVo);
    Result updateOrderPaymentStatus(Long orderId, String newStatus);
    Result insertOrder(OrderVo order);
    Result selectOrderById(Long id);
    Result selectAllOrders(Long id);
    Result updateOrder(OrderVo order);
    Result deleteOrderById(Long id);
}
