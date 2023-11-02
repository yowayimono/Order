package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String status;

    @TableField(value = "orderTime")
    private LocalDateTime orderTime;

    @TableField(value = "payTime")
    private LocalDateTime payTime;

    @TableField(value = "thingId")
    private Long thingId;

    @TableField(value = "userId")
    private Long userId;

    private String gwc;

    private BigDecimal amount;

    @TableField(value = "orderNumber")
    private String orderNumber;

    private String receiverAddress;

    private String receiverName;

    private String receiverPhone;

    private String remark;

}