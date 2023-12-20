package com.yowayimono.order_food.controller;


import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ProductService;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

@RestController
@Tag(name = "商家订单管理")
@RequestMapping(value = "/admin/order")
public class OrderAdminController {

    @Autowired
    ProductService ProductService;

    @Cacheable("products")
    @Operation(summary = "获取所有Products")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllProducts() {
        return ProductService.selectAllProducts();
    }




    @Operation(summary = "分页查询Products")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductsByPage(@RequestBody PageSelect page) {
        return ProductService.selectProductsWithPagination(page);
    }
}
