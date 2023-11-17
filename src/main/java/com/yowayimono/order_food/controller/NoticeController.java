package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.Notice;
import com.yowayimono.order_food.mapper.NoticeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Tag(name = "通知管理")
@RestController
@RequestMapping("/admin")
public class NoticeController {
    @Autowired
    NoticeMapper noticemapper;

    @Operation(summary = "通知推送")
    @RequestMapping(value = "/push",method = RequestMethod.POST)
    @ResponseBody
    public Result Push(@RequestBody Notice notice) {

        notice.setCreateTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());
        noticemapper.insert(notice);
        return Result.success(null);
    }
}
