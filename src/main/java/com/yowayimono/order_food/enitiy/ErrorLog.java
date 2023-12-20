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
@TableName("or_error_log")
public class ErrorLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "ip")
    private String ip;

    @TableField(value = "url")
    private String url;

    @TableField(value = "method")
    private String method;

    @TableField(value = "content")
    private String content;

    @TableField(value = "logTime")
    private LocalDateTime logTime;
}