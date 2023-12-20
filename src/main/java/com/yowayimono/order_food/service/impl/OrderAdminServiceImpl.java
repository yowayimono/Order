package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Product;
import com.yowayimono.order_food.mapper.ProductMapper;
import com.yowayimono.order_food.service.OrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAdminServiceImpl implements OrderAdminService {
    @Autowired
    ProductMapper ProductMapper;


    @Override
    public Result selectAllProducts() {
        try {
            List<Product> Products = ProductMapper.selectList(null);
            return Result.success(666, "查询成功！", Products);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
    @Override
    public Result selectProductsWithPagination(Long current, Long size) {
        try {
            Page<Product> page = new Page<>(current, size);
            IPage<Product> resultPage = ProductMapper.selectPage(page, null);

            return Result.success(666, "查询成功！", resultPage);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
}
