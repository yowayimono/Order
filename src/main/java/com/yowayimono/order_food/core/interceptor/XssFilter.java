package com.yowayimono.order_food.core.interceptor;

import jakarta.servlet.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

// @Configuration
public class XssFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}