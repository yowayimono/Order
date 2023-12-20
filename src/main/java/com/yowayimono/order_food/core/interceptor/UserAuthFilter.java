package com.yowayimono.order_food.core.interceptor;

import com.yowayimono.order_food.enitiy.User;
import com.yowayimono.order_food.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserAuthFilter implements WebMvcConfigurer {
    @Autowired
    UserMapper userMapper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
                    @Override
                    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                        String id = request.getHeader("id");
                        User user = userMapper.findUserById(Integer.parseInt(id));
                        if (user != null && user.getRole().equals("user")) {
                            return true;
                        }

                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        return false;
                    }
                }).addPathPatterns("/user/**")
                .excludePathPatterns("/user/login", "/user/register");
    }
}