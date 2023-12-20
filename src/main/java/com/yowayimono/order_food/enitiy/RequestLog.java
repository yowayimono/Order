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
@TableName("or_request_log")
public class RequestLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "reIp")
    private String requestIp;

    @TableField(value = "reTime")
    private LocalDateTime requestTime;

    @TableField(value = "reUa")
    private String requestUserAgent;

    @TableField(value = "reUrl")
    private String requestUrl;

    @TableField(value = "reMethod")
    private String requestMethod;

    @TableField(value = "reContent")
    private String requestContent;

    @TableField(value = "accessTime")
    private LocalDateTime accessTime;


}