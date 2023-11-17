package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;

import com.yowayimono.order_food.vo.ThingWishVo;

public interface ThingWishService {
    // Create
    Result insertThingWish(ThingWishVo thingwish);

    // Read
    Result selectThingWishById(Long id);



    Result selectThingWishesByUserId(Long userId);

    Result selectThingWishesByThingId(Long thingId);

    // Update


    // Delete
    Result deleteThingWishById(Long id);

    Result deleteThingWishesByUserId(Long userId);

    Result deleteThingWishesByThingId(Long thingId);

}
