package com.yowayimono.order_food.core.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.yowayimono.order_food.core.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Missing or invalid Authorization header");
            return false;
        }

        token = token.substring(7);
        Map<String, Claim> claims = JwtUtils.verifyToken(token);
        if (claims == null) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid token");
            return false;
        }

        // Add the claims to the request attributes so they can be accessed later
        request.setAttribute("claims", claims);

        return true;
    }
}