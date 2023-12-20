package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.CollectProduct;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yowayimono.order_food.vo.PageSelect;

public interface CollectProductService extends IService<CollectProduct> {

    Result addCollectProduct(CollectProduct collectProduct);

    Result deleteCollectProductById(Long id);

    Result updateCollectProduct(CollectProduct collectProduct);

    Result getCollectProductById(Long id);

    Result getCollectProducts(PageSelect pageSelect);

    Result getCollectProducts(Long userid);
}
