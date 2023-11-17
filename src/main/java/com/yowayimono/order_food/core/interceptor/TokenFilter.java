package com.yowayimono.order_food.core.interceptor;

import com.auth0.jwt.interfaces.Claim;

import com.yowayimono.order_food.core.entity.Result;
import com.yowayimono.order_food.core.utils.JwtTokenUtils;
import com.yowayimono.order_food.core.utils.RedisUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// /api/user/secure/* 的文件起作用
@Configuration
public class TokenFilter implements WebMvcConfigurer {
    @Autowired
    RedisUtils redisUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String token = request.getHeader("token");
                if(token != null && redisUtils.get(token)!=null){
                    redisUtils.expire(token,30, TimeUnit.MINUTES);
                    return true;
                }

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        }).excludePathPatterns("/user/login","/user/register");
    }
}