package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.ErrorLog;
import com.yowayimono.order_food.mapper.ErrorLogMapper;
import com.yowayimono.order_food.service.ErrorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorLogServiceImpl implements ErrorLogService {

    @Autowired
    private ErrorLogMapper errorLogMapper;

    @Override
    public Result insertErrorLog(ErrorLog errorLog) {
        try {
            int result = errorLogMapper.insert(errorLog);
            if (result > 0) {
                return Result.success(666, "添加成功！", errorLog);
            } else {
                return Result.fail(4444, "添加失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "添加失败！");
        }
    }

    @Override
    public Result selectErrorLogById(Long id) {
        try {
            ErrorLog errorLog = errorLogMapper.selectById(id);
            if (errorLog != null) {
                return Result.success(666, "查询成功！", errorLog);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }
    @Override
    public Result selectErrorLogsByPage(Long current, Long size) {
        try {
            List<ErrorLog> errorLogs = errorLogMapper.selectByPage((current - 1) * size, size);
            return Result.success(666, "查询成功！", errorLogs);
        } catch (Exception e) {

            return Result.fail(4444, "查询失败！");
        }
    }
    @Override
    public Result selectAllErrorLogs() {
        try {
            List<ErrorLog> errorLogs = errorLogMapper.selectList(null);
            return Result.success(666, "查询成功！", errorLogs);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result deleteErrorLogById(Long id) {
        try {
            int result = errorLogMapper.deleteById(id);
            if (result > 0) {
                return Result.success(666, "删除成功！", id);
            } else {
                return Result.fail(4444, "删除失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "删除失败！");
        }
    }
}
