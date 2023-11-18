package com.yowayimono.order_food.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Thing;
import com.yowayimono.order_food.mapper.ThingMapper;
import com.yowayimono.order_food.service.OrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAdminServiceImpl implements OrderAdminService {
    @Autowired
    ThingMapper thingMapper;


    @Override
    public Result selectAllThings() {
        try {
            List<Thing> things = thingMapper.selectList(null);
            return Result.success(666, "查询成功！", things);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
    @Override
    public Result selectThingsWithPagination(Long current, Long size) {
        try {
            Page<Thing> page = new Page<>(current, size);
            IPage<Thing> resultPage = thingMapper.selectPage(page, null);

            return Result.success(666, "查询成功！", resultPage);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
}
