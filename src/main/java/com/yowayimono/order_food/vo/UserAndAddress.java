package com.yowayimono.order_food.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAndAddress {

    private String name;


    private String mobile;


    private String title;



    private String description;

    private String def;



    private Long userId;

    // 省略 getter 和 setter 方法
}
