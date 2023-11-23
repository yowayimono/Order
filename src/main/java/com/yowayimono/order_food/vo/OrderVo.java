package com.yowayimono.order_food.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yowayimono.order_food.core.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderVo {

    private Long thingId;


    private Long userId;

    private String gwc;

    private BigDecimal amount;


    private String orderNumber;

    private String receiverAddress;

    private String receiverName;

    private String receiverPhone;

    private String remark;

}