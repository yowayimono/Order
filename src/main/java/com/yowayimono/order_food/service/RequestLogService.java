package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.RequestLog;

public interface RequestLogService {

    Result insertOpLog(RequestLog requestLog);

    Result selectOpLogById(Long id);

    Result selectAllOpLogs();

    Result selectByPage(Long current, Long size);
    Result deleteOpLogById(Long id);
}
