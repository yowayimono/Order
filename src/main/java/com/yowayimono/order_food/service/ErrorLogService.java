package com.yowayimono.order_food.service;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.enitiy.ErrorLog;

public interface ErrorLogService {

    Result insertErrorLog(ErrorLog errorLog);

    Result selectErrorLogById(Long id);
    Result selectErrorLogsByPage(Long current, Long size);
    Result selectAllErrorLogs();

    Result deleteErrorLogById(Long id);
}
