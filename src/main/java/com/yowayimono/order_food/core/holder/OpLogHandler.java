package com.yowayimono.order_food.core.holder;

import com.alibaba.fastjson2.JSON;
import com.yowayimono.order_food.core.utils.HttpContextUtils;
import com.yowayimono.order_food.core.utils.IpUtils;
import com.yowayimono.order_food.enitiy.RequestLog;
import com.yowayimono.order_food.mapper.RequestLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;

@Aspect
@Component
public class OpLogHandler {


    @Autowired
    RequestLogMapper requestLogMapper;

    @Before("execution(* com.yowayimono.order_food.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String requestIp = IpUtils.getIpAddr(request);
        String requestUserAgent = request.getHeader("User-Agent");
        String requestUrl = request.getRequestURI();
        String requestMethod = request.getMethod();
        LocalDateTime requestTime = LocalDateTime.now();

        RequestLog log = new RequestLog();
        log.setRequestIp(requestIp);
        log.setRequestUserAgent(requestUserAgent);
        log.setRequestUrl(requestUrl);
        log.setRequestMethod(requestMethod);
        Map<String, String> params = HttpContextUtils.getParameterMap(request);
        if(!params.isEmpty()){
            log.setRequestContent(JSON.toJSONString(params));
        }else {
            log.setRequestContent("空");
        }


        String requestBody = request.getQueryString();
        if(requestBody != null) {
            log.setRequestContent(URLDecoder.decode(requestBody, StandardCharsets.UTF_8));
        }else{
            log.setRequestContent("空");
        }

        log.setRequestTime(requestTime);
        log.setAccessTime(LocalDateTime.now());

        // Save log to database or perform any other action
        // errorLogMapper.insert(log);


        requestLogMapper.insert(log);
        System.out.println(log);
    }

    private String getRequestContent(JoinPoint joinPoint) {
        // Implement logic to get request content from the joinPoint
        // For example, you can inspect method arguments
        Object[] args = joinPoint.getArgs();
        // Convert args to JSON or any other format based on your requirement
        return args.toString();
    }
}
