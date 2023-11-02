package com.yowayimono.order_food.core.utils;

import com.yowayimono.order_food.enitiy.User;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.context.annotation.Configuration;



public class JwtUtils {

    /**
     * 加密盐值
     */
    //@Value("${application.minjwt.secret}")
    private static  String secretKey = "0503qwm";

    /**
     * Token失效时间
     */
    //@Value("${application.minjwt.expiration}")
    private static long jwtExpiration = 3600*24L;
    /**
     * Token刷新时间
     */
    //@Value("${application.jwt.refresh-token.expiration}")
    private static long refreshExpiration =3600*24*10L;


    // 生成 token
    public  static String createToken(User user) {
        Date expireDate = new Date(System.currentTimeMillis() + jwtExpiration );
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        //System.out.println(user+"user");
        String token = JWT.create()
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("password", user.getPassword())
                .withExpiresAt(expireDate)
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(secretKey));

        return token;
    }

    // 校验 token
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            return null;
        }
        return jwt.getClaims();
    }
}
