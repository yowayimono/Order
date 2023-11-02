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
@TableName("or_classification")
public class Classification {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String title;

    @TableField(value = "createTime")
    private LocalDateTime createTime;

    // 省略 getter 和 setter 方法
}
