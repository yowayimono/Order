package com.yowayimono.order_food.core.holder;

import com.alibaba.fastjson2.JSON;
import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.HttpContextUtils;
import com.yowayimono.order_food.core.utils.IpUtils;
import com.yowayimono.order_food.mapper.ErrorLogMapper;
import com.yowayimono.order_food.service.ErrorLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.yowayimono.order_food.enitiy.ErrorLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;



@RestControllerAdvice
public class ErrLogHandler {
    // private static final Logger logger = LoggerFactory.getLogger(ErrLogHandler.class);

    @Autowired
    private ErrorLogMapper ErrorLogMapper;

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex){
        // logger.error("error log======>" + ex.getMessage(), ex);

        saveLog(ex);
        return Result.success(4444, ex.getMessage());
    }


    private void saveLog(Exception ex){
        ErrorLog log = new ErrorLog();
        //请求相关信息
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.setIp(IpUtils.getIpAddr(request));
        log.setUrl(request.getRequestURI());
        log.setMethod(request.getMethod());

        Map<String, String> params = HttpContextUtils.getParameterMap(request);
        if(!params.isEmpty()){
            log.setContent(JSON.toJSONString(params));
        }else {
            log.setContent("空");
        }


        String requestBody = request.getQueryString();
        if(requestBody != null) {
            log.setContent(URLDecoder.decode(requestBody, StandardCharsets.UTF_8));
        }else{
            log.setContent("空");
        }

        //log.setContent(requestBody);
        System.out.println(requestBody);
        //log.setContent(Arrays.toString(ex.getStackTrace()));
        log.setLogTime(Timestamp.valueOf(LocalDateTime.now()).toLocalDateTime());

        ErrorLogMapper.insert(log);

    }
}
