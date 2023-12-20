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
@TableName("or_collect") // 购物车，是一个商品集合
public class CollectProduct {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "productId")
    private Long productId;

    @TableField(value = "userId")
    private Long userId;
}