package com.yowayimono.order_food.service.impl;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.RequestLog;
import com.yowayimono.order_food.mapper.RequestLogMapper;

import com.yowayimono.order_food.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RequestLogServiceImpl implements RequestLogService {

    @Autowired
    private RequestLogMapper requestLogMapper;

    @Override
    public Result insertOpLog(RequestLog requestLog) {
        try {
            int result = requestLogMapper.insert(requestLog);
            if (result > 0) {
                return Result.success(666, "添加成功！", requestLog);
            } else {
                return Result.fail(4444, "添加失败！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "添加失败！");
        }
    }

    @Override
    public Result selectOpLogById(Long id) {
        try {
            RequestLog requestLog = requestLogMapper.selectById(id);
            if (requestLog != null) {
                return Result.success(666, "查询成功！", requestLog);
            } else {
                return Result.fail(4444, "未找到对应记录！");
            }
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectAllOpLogs() {
        try {
            List<RequestLog> requestLogs = requestLogMapper.selectList(null);
            return Result.success(666, "查询成功！", requestLogs);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result selectByPage(Long current, Long size) {
        try {
            List<RequestLog> requestLogs = requestLogMapper.selectByPage(current,size);
            return Result.success(666, "查询成功！", requestLogs);
        } catch (Exception e) {
            return Result.fail(4444, "查询失败！");
        }
    }

    @Override
    public Result deleteOpLogById(Long id) {
        try {
            int result = requestLogMapper.deleteById(id);
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
