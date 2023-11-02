package com.yowayimono.order_food.core.annotation;

import java.lang.annotation.*;

/**
 * @author cyl
 * @date 2023-04-28 9:58
 * @description 加解密请求参数注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SecretParam {

    boolean encrypt() default true;

    boolean decrypt() default true;
}
