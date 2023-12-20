package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ProductTagService;
import com.yowayimono.order_food.vo.ProductTagVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

@RestController
@Tag(name = "商品标签管理")
@RequestMapping(value = "/admin/Tag")
public class ProductTagController {

    @Autowired
    private ProductTagService ProductTagService;

    @Operation(summary = "添加ProductTag")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertProductTag(@RequestBody ProductTagVo ProductTagVo) {
        return ProductTagService.insertProductTag(ProductTagVo);
    }
    @Cacheable("products")
    @Operation(summary = "获取ProductTag详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductTagById(@PathVariable Long id) {
        return ProductTagService.selectProductTagById(id);
    }
    @Cacheable("products")
    @Operation(summary = "获取所有ProductTags")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllProductTags() {
        return ProductTagService.selectAllProductTags();
    }
    @Cacheable("products")
    @Operation(summary = "获取某个Product下的所有ProductTags")
    @RequestMapping(value = "/getByProductId/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductTagsByProductId(@PathVariable Long ProductId) {
        return ProductTagService.selectProductTagsByProductId(ProductId);
    }





        @Operation(summary = "获取某个标签下的所有商品")
        @RequestMapping(value = "/getProductsByTagId/{tagId}", method = RequestMethod.GET)
        @ResponseBody
        public Result getProductsByTagId(@PathVariable Long tagId) {
            return ProductTagService.selectProductsByTagId(tagId);
        }

        @Operation(summary = "获取某个商品下的所有标签")
        @RequestMapping(value = "/getTagsByProductId/{ProductId}", method = RequestMethod.GET)
        @ResponseBody
        public Result getTagsByProductId(@PathVariable Long ProductId) {
            return ProductTagService.selectTagsByProductId(ProductId);
        }

        // Additional methods can be added here





    @Operation(summary = "获取某个Tag下的所有ProductTags")
    @RequestMapping(value = "/getByTagId/{tagId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getProductTagsByTagId(@PathVariable Long tagId) {
        return ProductTagService.selectProductTagsByTagId(tagId);
    }

    @Operation(summary = "更新ProductTag")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateProductTag(@RequestBody ProductTagVo ProductTagVo) {
        return ProductTagService.updateProductTag(ProductTagVo);
    }

    @Operation(summary = "删除ProductTag by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteProductTagById(@PathVariable Long id) {
        return ProductTagService.deleteProductTagById(id);
    }

    // Additional methods can be added here

}
