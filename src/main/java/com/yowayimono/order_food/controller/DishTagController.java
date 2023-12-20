package com.yowayimono.order_food.controller;


import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.mapper.DishTagMapper;
import com.yowayimono.order_food.service.DishTagService;
import com.yowayimono.order_food.vo.PageSelect;
import com.yowayimono.order_food.vo.TagVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@io.swagger.v3.oas.annotations.tags.Tag(name="标签管理")
@RestController
@RequestMapping(value = "/admin/tag")
public class DishTagController {

    @Autowired
    DishTagMapper dishTagMapper;

    @Autowired
    DishTagService dishTagService;



    @ResponseBody
    @Operation(summary="添加标签")
    @RequestMapping(value = "/addtag",method = RequestMethod.POST)
    public Result AddTag(@RequestBody TagVo tag) {
        System.out.println(tag);
        return dishTagService.AddTag(tag);
    }

    @ResponseBody
    @Operation(summary="删除标签")
    @RequestMapping(value = "/deltag", method = RequestMethod.POST)
    public Result DelTag(@RequestParam("title") String tagTitle) {
        return dishTagService.DelTag(tagTitle);
    }

    @ResponseBody
    @Operation(summary="查找标签")
    @RequestMapping(value = "/findtag", method = RequestMethod.GET)
    public Result FindTag(@RequestBody PageSelect page) {

        return dishTagService.FindTagByPage(page);
    }

    @ResponseBody
    @Operation(summary="根据名称查找标签")
    @RequestMapping(value = "/findtagbyname", method = RequestMethod.GET)
    public Result FindTagByName(@RequestParam("title") String tagTitle) {
        return FindTagByName(tagTitle);
    }

    @ResponseBody
    @Operation(summary="按部分匹配查找标签")
    @RequestMapping(value = "/match-tag", method = RequestMethod.GET)
    public Result MatchTag(@RequestParam("term") String term) {
        return dishTagService.MatchTag(term);
    }
}
