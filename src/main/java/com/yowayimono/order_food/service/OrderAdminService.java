package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;

public interface OrderAdminService {
    Result selectAllProducts();
    Result selectProductsWithPagination(Long current, Long size);
}
