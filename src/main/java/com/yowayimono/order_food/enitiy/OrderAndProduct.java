package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_order_Product")
public class OrderAndProduct {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "orderId")
    private Long orderId;

    @TableField(value = "productId")
    private Long ProductId;

    @TableField(value = "quantity")
    private Integer quantity;
}
