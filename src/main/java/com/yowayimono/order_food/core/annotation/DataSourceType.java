package com.yowayimono.order_food.core.annotation;

import com.yowayimono.order_food.core.constant.DataSourceTypeEnum;

import java.lang.annotation.*;

/**
 * @author cyl
 * @date 2023-04-28 11:17
 * @description 多数据源类型
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceType {

    DataSourceTypeEnum value() default DataSourceTypeEnum.PRIMARY;
}
