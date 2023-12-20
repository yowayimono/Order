package com.yowayimono.order_food.controller;



import com.yowayimono.order_food.core.entity.Result;

import com.yowayimono.order_food.service.WishService;

import com.yowayimono.order_food.vo.ThingWishVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;


@RestController
@Tag(name = "用户心愿单管理")
@RequestMapping(value = "/user/Productwish")
public class WishController {

    @Autowired
    private WishService ProductWishService;

    @Operation(summary = "添加ProductWish")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertProductWish(@RequestBody ThingWishVo ProductWish) {
        return ProductWishService.insertProductWish(ProductWish);
    }

    @Cacheable("products")
    @Operation(summary = "获取ProductWish详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductWishById(@PathVariable Long id) {
        return ProductWishService.selectProductWishById(id);
    }
    @Cacheable("products")
    @Operation(summary = "获取某个用户所有ProductWish")
    @RequestMapping(value = "/getAllByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllProductWishesByUserId(Long userId) {
        return ProductWishService.selectProductWishesByUserId(userId);
    }
    @Cacheable("products")
    @Operation(summary = "获取某个Product所有ProductWish")
    @RequestMapping(value = "/getAllByProductId", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllProductWishesByProductId(Long ProductId) {
        return ProductWishService.selectProductWishesByProductId(ProductId);
    }

    @Operation(summary = "删除ProductWish by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProductWishById(@PathVariable Long id) {
        return ProductWishService.deleteProductWishById(id);
    }

    @Operation(summary = "删除某个用户所有ProductWish")
    @RequestMapping(value = "/deleteAllByUserId/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProductWishesByUserId(@PathVariable Long userId) {
        return ProductWishService.deleteProductWishesByUserId(userId);
    }

    @Operation(summary = "删除某个Product所有ProductWish")
    @RequestMapping(value = "/deleteAllByProductId/{ProductId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProductWishesByProductId(@PathVariable Long ProductId) {
        return ProductWishService.deleteProductWishesByProductId(ProductId);
    }



}
