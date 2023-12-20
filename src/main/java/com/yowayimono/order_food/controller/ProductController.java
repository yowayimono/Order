package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ProductService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.ThingVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

@RestController
@Tag(name = "商品管理(已测试)")
@RequestMapping(value = "/admin/Product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @Cacheable("products")
    @Operation(summary = "获取商品数量")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public Result countProducts() {
        return ProductService.countProducts();
    }

    @Operation(summary = "添加Product")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertProduct(@RequestBody ThingVo ThingVo) {
        return ProductService.insertProduct(ThingVo);
    }
    @Cacheable("products")
    @Operation(summary = "获取Product详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductById(@PathVariable Long id) {
        return ProductService.selectProductById(id);
    }


    @Operation(summary = "更新商品状态")
    @RequestMapping(value = "/updateStatus/{ProductId}/{status}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProductStatus(@PathVariable Long ProductId, @PathVariable String status) {
        return ProductService.updateProductStatus(ProductId, status);
    }

    @Cacheable("products")
    @Operation(summary = "获取所有Products")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllProducts() {
        return ProductService.selectAllProducts();
    }

    @Operation(summary = "更新Product")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProduct(@RequestBody ThingVo ThingVo) {
        return ProductService.updateProduct(ThingVo);
    }

    @Operation(summary = "删除Product by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProductById(@PathVariable Long id) {
        return ProductService.deleteProductById(id);
    }
    @Cacheable("products")
    @Operation(summary = "分页查询Products")
    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductsByPage(@RequestBody PageSelect page) {
        return ProductService.selectProductsWithPagination(page);
    }
}
