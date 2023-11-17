package com.yowayimono.order_food.controller;



import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ThingWishService;
import com.yowayimono.order_food.vo.ThingWishVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Tag(name = "用户心愿单管理")
@RequestMapping(value = "/user/thingwish")
public class ThingWishController {

    @Autowired
    private ThingWishService thingWishService;

    @Operation(summary = "添加ThingWish")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertThingWish(@RequestBody ThingWishVo thingWish) {
        return thingWishService.insertThingWish(thingWish);
    }

    @Operation(summary = "获取ThingWish详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingWishById(@PathVariable Long id) {
        return thingWishService.selectThingWishById(id);
    }

    @Operation(summary = "获取某个用户所有ThingWish")
    @RequestMapping(value = "/getAllByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllThingWishesByUserId(Long userId) {
        return thingWishService.selectThingWishesByUserId(userId);
    }

    @Operation(summary = "获取某个Thing所有ThingWish")
    @RequestMapping(value = "/getAllByThingId", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllThingWishesByThingId(Long thingId) {
        return thingWishService.selectThingWishesByThingId(thingId);
    }

    @Operation(summary = "删除ThingWish by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteThingWishById(@PathVariable Long id) {
        return thingWishService.deleteThingWishById(id);
    }

    @Operation(summary = "删除某个用户所有ThingWish")
    @RequestMapping(value = "/deleteAllByUserId/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteThingWishesByUserId(@PathVariable Long userId) {
        return thingWishService.deleteThingWishesByUserId(userId);
    }

    @Operation(summary = "删除某个Thing所有ThingWish")
    @RequestMapping(value = "/deleteAllByThingId/{thingId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteThingWishesByThingId(@PathVariable Long thingId) {
        return thingWishService.deleteThingWishesByThingId(thingId);
    }



}
