package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ThingService;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户订单管理管理")
@RequestMapping(value = "/user/order")
public class OrderUserController {
    @Autowired
    ThingService thingService;

    @Operation(summary = "获取所有Things")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllThings() {
        return thingService.selectAllThings();
    }

    @Operation(summary = "分页查询Things")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingsByPage(@RequestBody PageSelect page) {
        return thingService.selectThingsWithPagination(page.getOffect(), page.getPagesize());
    }
}
