package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.ThingVo;

public interface ProductService {
    Result insertProduct(ThingVo ThingVo);

    Result selectProductById(Long id);

    Result selectAllProducts();

    Result updateProduct(ThingVo ThingVo);

    Result deleteProductById(Long id);
    Result updateProductStatus(Long ProductId, String status);
    Result countProducts();
    Result selectProductsWithPagination(PageSelect page);
}
