package com.yowayimono.order_food.controller;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.ErrorLog;
import com.yowayimono.order_food.service.ErrorLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "错误日志管理")
@RequestMapping("/admin/errorlog")
public class ErrorLogController {

    @Autowired
    private ErrorLogService errorLogService;

    @Operation(summary = "添加错误日志")
    @PostMapping("/insert")
    public Result insertErrorLog(@RequestBody ErrorLog errorLog) {
        return errorLogService.insertErrorLog(errorLog);
    }

    @Operation(summary = "根据ID查询错误日志")
    @GetMapping("/get/{id}")
    public Result selectErrorLogById(@PathVariable Long id) {
        return errorLogService.selectErrorLogById(id);
    }
    @Operation(summary = "分页查询错误日志")
    @GetMapping("/getByPage")
    @ResponseBody
    public Result getErrorLogsByPage(@RequestParam Long current, @RequestParam Long size) {
        return errorLogService.selectErrorLogsByPage(current, size);
    }
    @Operation(summary = "查询所有错误日志")
    @GetMapping("/getAll")
    public Result selectAllErrorLogs() {
        return errorLogService.selectAllErrorLogs();
    }

    @Operation(summary = "根据ID删除错误日志")
    @DeleteMapping("/delete/{id}")
    public Result deleteErrorLogById(@PathVariable Long id) {
        return errorLogService.deleteErrorLogById(id);
    }
}
