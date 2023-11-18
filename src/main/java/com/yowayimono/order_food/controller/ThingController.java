package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ThingService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.ThingVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "商品管理")
@RequestMapping(value = "/admin/thing")
public class ThingController {

    @Autowired
    private ThingService thingService;

    @Operation(summary = "添加Thing")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertThing(@RequestBody ThingVo thingVo) {
        return thingService.insertThing(thingVo);
    }

    @Operation(summary = "获取Thing详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingById(@PathVariable Long id) {
        return thingService.selectThingById(id);
    }


    @Operation(summary = "更新商品状态")
    @RequestMapping(value = "/updateStatus/{thingId}/{status}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateThingStatus(@PathVariable Long thingId, @PathVariable String status) {
        return thingService.updateThingStatus(thingId, status);
    }


    @Operation(summary = "获取所有Things")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllThings() {
        return thingService.selectAllThings();
    }

    @Operation(summary = "更新Thing")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateThing(@RequestBody ThingVo thingVo) {
        return thingService.updateThing(thingVo);
    }

    @Operation(summary = "删除Thing by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteThingById(@PathVariable Long id) {
        return thingService.deleteThingById(id);
    }

    @Operation(summary = "分页查询Things")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingsByPage(@RequestBody PageSelect page) {
        return thingService.selectThingsWithPagination(page.getOffect(), page.getPagesize());
    }
}
