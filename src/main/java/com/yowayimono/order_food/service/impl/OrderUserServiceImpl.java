package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Thing;
import com.yowayimono.order_food.mapper.ThingMapper;
import com.yowayimono.order_food.service.OrderUserService;
import com.yowayimono.order_food.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUserServiceImpl implements OrderUserService {
    @Autowired
    ThingMapper thingMapper;


    @Override
    public Result selectAllThings() {
        try {
            QueryWrapper<Thing> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "上架"); // 添加查询条件

            List<Thing> things = thingMapper.selectList(queryWrapper);
            return Result.success(666, "查询成功！", things);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectThingsWithPagination(Long current, Long size) {
        try {
            Page<Thing> page = new Page<>(current, size);

            // 添加查询条件
            QueryWrapper<Thing> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("status", "上架");

            IPage<Thing> resultPage = thingMapper.selectPage(page, queryWrapper);

            return Result.success(666, "查询成功！", resultPage);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

}
