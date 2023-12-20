package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.CollectProduct;
import com.yowayimono.order_food.mapper.CollectProductMapper;

import com.yowayimono.order_food.service.CollectProductService;
import com.yowayimono.order_food.vo.PageSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class CollectProductServiceImpl extends ServiceImpl<CollectProductMapper, CollectProduct> implements CollectProductService {

    @Autowired
    CollectProductMapper collectProductMapper;

    @Override
    public Result addCollectProduct(CollectProduct collectProduct) {
        int result = collectProductMapper.insert(collectProduct);
        if (result > 0) {
            return Result.success("收藏商品成功");
        } else {
            return Result.fail("收藏商品失败");
        }
    }

    @Override
    public Result deleteCollectProductById(Long id) {
        int result = collectProductMapper.deleteById(id);
        if (result > 0) {
            return Result.success("删除收藏商品成功");
        } else {
            return Result.fail("删除收藏商品失败");
        }
    }

    @Override
    public Result updateCollectProduct(CollectProduct collectProduct) {
        int result = collectProductMapper.updateById(collectProduct);
        if (result > 0) {
            return Result.success("更新收藏商品成功");
        } else {
            return Result.fail("更新收藏商品失败");
        }
    }

    @Override
    public Result getCollectProductById(Long id) {
        CollectProduct collectProduct = collectProductMapper.selectById(id);
        if (collectProduct != null) {
            return Result.success(collectProduct);
        } else {
            return Result.fail("收藏商品不存在");
        }
    }

    @Override
    public Result getCollectProducts(PageSelect pageSelect) {
        return null;
    }

    @Override
    public Result getCollectProducts(Long userid) {

        List<CollectProduct> collectProductList = collectProductMapper.getCollectProducts(userid);
        return Result.success(collectProductList);
    }
}
