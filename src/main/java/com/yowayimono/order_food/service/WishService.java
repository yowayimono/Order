package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;


import com.yowayimono.order_food.vo.ThingWishVo;

public interface WishService {

    Result insertProductWish(ThingWishVo Productwish);


    Result selectProductWishById(Long id);


    Result selectProductWishesByUserId(Long userId);

    Result selectProductWishesByProductId(Long ProductId);




    Result deleteProductWishById(Long id);

    Result deleteProductWishesByUserId(Long userId);

    Result deleteProductWishesByProductId(Long ProductId);

}
