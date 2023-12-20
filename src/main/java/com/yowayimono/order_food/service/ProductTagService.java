package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.ProductTagVo;

public interface ProductTagService {
    Result insertProductTag(ProductTagVo ProductTagVo);

    Result selectProductTagById(Long id);

    Result selectAllProductTags();

    Result selectProductTagsByProductId(Long ProductId);

    Result selectProductTagsByTagId(Long tagId);

    Result updateProductTag(ProductTagVo ProductTagVo);

    Result selectProductsByTagId(Long tagId);

    Result selectTagsByProductId(Long ProductId);

    Result deleteProductTagById(Long id);
}
