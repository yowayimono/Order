package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    private String name;

    private String mobile;

    private String description;

    private String def;

    @TableField(value = "createTime")
    private LocalDateTime createTime;

    @TableField(value = "userId")
    private Long userId;

    // 省略 getter 和 setter 方法
}