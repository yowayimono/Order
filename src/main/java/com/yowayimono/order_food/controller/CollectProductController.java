package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.CollectProduct;

import com.yowayimono.order_food.mapper.CollectProductMapper;
import com.yowayimono.order_food.service.CollectProductService;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

@Tag(name = "购物车管理")
@RestController
@RequestMapping("/user/collect")
public class CollectProductController {

    @Autowired
    CollectProductService collectProductService;

    @Autowired
    CollectProductMapper cpMapper;

    @Cacheable("collects")
    @Operation(summary = "查询购物车商品（）")
    @PostMapping("/getpage")
    @ResponseBody
    public Result getCollectProducts(@RequestBody Long userid) {
        return collectProductService.getCollectProducts(userid);
    }

    @Operation(summary = "添加新商品到购物车，通过userid和productid")
    @PostMapping("/add")
    @ResponseBody
    public Result AddProduct(@RequestBody Long userid,Long productid){
        CollectProduct cp = new CollectProduct();
        cp.setProductId(productid);
        cp.setUserId(userid);

        if(cpMapper.insert(cp) > 0){
            return Result.fail(4444,"数据插入失误！");
        }

        return Result.success(200,"插入成功！");
    }

}
