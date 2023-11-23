package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;

import com.yowayimono.order_food.vo.ThingWishVo;

public interface ThingWishService {

    Result insertThingWish(ThingWishVo thingwish);


    Result selectThingWishById(Long id);



    Result selectThingWishesByUserId(Long userId);

    Result selectThingWishesByThingId(Long thingId);




    Result deleteThingWishById(Long id);

    Result deleteThingWishesByUserId(Long userId);

    Result deleteThingWishesByThingId(Long thingId);

}
