package com.yowayimono.order_food.enitiy;

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
@TableName("or_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "status") //已支付，未支付，待评价，已完成，已取消
    private OrderStatus status;

    @TableField(value = "createTime")
    private LocalDateTime createTime;

    @TableField(value = "payTime")
    private LocalDateTime payTime;

    @TableField(value = "deletetime")
    private LocalDateTime deletetime;

    @TableField(value = "userId")
    private Long userId;

    @TableField(value = "amount")
    private BigDecimal amount;

    @TableField(value = "addrId")
    private Long addrId;

    @TableField(value = "remark")
    private String remark;
}
