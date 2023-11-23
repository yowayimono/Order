package com.yowayimono.order_food.controller;


import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.RedisUtils;
import com.yowayimono.order_food.enitiy.Tag;
import com.yowayimono.order_food.mapper.TagMapper;
import com.yowayimono.order_food.service.TagService;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@io.swagger.v3.oas.annotations.tags.Tag(name="标签管理")
@RestController
@RequestMapping(value = "/admin/tag")
public class TagController {

    @Autowired
    TagMapper tagMapper;

    @Autowired
    TagService tagService;



    @ResponseBody
    @Operation(summary="添加标签")
    @RequestMapping(value = "/addtag",method = RequestMethod.POST)
    public Result AddTag(@RequestParam("title") String TagTitle) {
        System.out.println(TagTitle);
        return tagService.AddTag(TagTitle);
    }

    @ResponseBody
    @Operation(summary="删除标签")
    @RequestMapping(value = "/deltag", method = RequestMethod.POST)
    public Result DelTag(@RequestParam("title") String tagTitle) {
        return tagService.DelTag(tagTitle);
    }

    @ResponseBody
    @Operation(summary="查找标签")
    @RequestMapping(value = "/findtag", method = RequestMethod.GET)
    public Result FindTag(@RequestBody PageSelect page) {

        return tagService.FindTag(page);
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
        return tagService.MatchTag(term);
    }
}
