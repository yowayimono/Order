package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_address")
public class Address {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String mobile;

    @NotNull
    private String title;

    private LocalDateTime deleteTime;

    @NotNull
    private String description;

    private String def;

    @TableField(value = "createTime")
    @NotNull
    private LocalDateTime createTime;

    @TableField(value = "userId")
    @NotNull
    private Long userId;

    // 省略 getter 和 setter 方法
}