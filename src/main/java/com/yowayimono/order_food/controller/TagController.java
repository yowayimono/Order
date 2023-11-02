package com.yowayimono.order_food.controller;


import com.yowayimono.order_food.core.utils.RedisUtils;
import com.yowayimono.order_food.enitiy.Tag;
import com.yowayimono.order_food.mapper.TagMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;



@io.swagger.v3.oas.annotations.tags.Tag(name="标签管理")
@RestController
public class TagController {

    @Autowired
    TagMapper tagmapper;



    @ResponseBody
    @Operation(summary="添加标签")
    @RequestMapping(value = "/add-tag",method = RequestMethod.POST)
    public String AddTime(@RequestBody Tag tag) {

        tag.setCreatetime(Timestamp.valueOf(LocalDateTime.now()));
        return tagmapper.insert(tag)>0?"sucess!":"filed!";
    }
}
