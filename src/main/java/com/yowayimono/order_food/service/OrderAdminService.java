package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;

public interface OrderAdminService {
    Result selectAllThings();
    Result selectThingsWithPagination(Long current, Long size);
}
