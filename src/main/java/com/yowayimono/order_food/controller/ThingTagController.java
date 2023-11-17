package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.service.ThingTagService;
import com.yowayimono.order_food.vo.ThingTagVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "商品标签管理")
@RequestMapping(value = "/admin/thingtag")
public class ThingTagController {

    @Autowired
    private ThingTagService thingTagService;

    @Operation(summary = "添加ThingTag")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertThingTag(@RequestBody ThingTagVo thingTagVo) {
        return thingTagService.insertThingTag(thingTagVo);
    }

    @Operation(summary = "获取ThingTag详情")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingTagById(@PathVariable Long id) {
        return thingTagService.selectThingTagById(id);
    }

    @Operation(summary = "获取所有ThingTags")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllThingTags() {
        return thingTagService.selectAllThingTags();
    }

    @Operation(summary = "获取某个Thing下的所有ThingTags")
    @RequestMapping(value = "/getByThingId/{thingId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingTagsByThingId(@PathVariable Long thingId) {
        return thingTagService.selectThingTagsByThingId(thingId);
    }





        @Operation(summary = "获取某个标签下的所有商品")
        @RequestMapping(value = "/getThingsByTagId/{tagId}", method = RequestMethod.GET)
        @ResponseBody
        public Result getThingsByTagId(@PathVariable Long tagId) {
            return thingTagService.selectThingsByTagId(tagId);
        }

        @Operation(summary = "获取某个商品下的所有标签")
        @RequestMapping(value = "/getTagsByThingId/{thingId}", method = RequestMethod.GET)
        @ResponseBody
        public Result getTagsByThingId(@PathVariable Long thingId) {
            return thingTagService.selectTagsByThingId(thingId);
        }

        // Additional methods can be added here





    @Operation(summary = "获取某个Tag下的所有ThingTags")
    @RequestMapping(value = "/getByTagId/{tagId}", method = RequestMethod.GET)
    @ResponseBody
    public Result getThingTagsByTagId(@PathVariable Long tagId) {
        return thingTagService.selectThingTagsByTagId(tagId);
    }

    @Operation(summary = "更新ThingTag")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateThingTag(@RequestBody ThingTagVo thingTagVo) {
        return thingTagService.updateThingTag(thingTagVo);
    }

    @Operation(summary = "删除ThingTag by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteThingTagById(@PathVariable Long id) {
        return thingTagService.deleteThingTagById(id);
    }

    // Additional methods can be added here

}
