package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.RequestLog;


import com.yowayimono.order_food.service.RequestLogService;
import com.yowayimono.order_food.vo.PageSelect;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Tag(name = "操作日志管理")
@RequestMapping("/admin/oplog")
public class OpLogController {

    @Autowired
    private RequestLogService opLogService;

    @Operation(summary = "添加操作日志")
    @PostMapping("/insert")
    public Result insertOpLog(@RequestBody RequestLog requestLog) {
        return opLogService.insertOpLog(requestLog);
    }

    @Operation(summary = "根据ID查询操作日志")
    @GetMapping("/get/{id}")
    public Result selectOpLogById(@PathVariable Long id) {
        return opLogService.selectOpLogById(id);
    }

    @Operation(summary = "查询所有操作日志")
    @GetMapping("/getAll")
    public Result selectAllOpLogs() {
        return opLogService.selectAllOpLogs();
    }


    @Operation(summary = "分页查询所有操作日志")
    @GetMapping("/getByPage")
    public Result selectAllOpLogs(PageSelect page) {
        return opLogService.selectAllOpLogs();
    }
    @Operation(summary = "根据ID删除操作日志")
    @DeleteMapping("/delete/{id}")
    public Result deleteOpLogById(@PathVariable Long id) {
        return opLogService.deleteOpLogById(id);
    }
}
