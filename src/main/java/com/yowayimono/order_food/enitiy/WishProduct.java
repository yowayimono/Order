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
@TableName("or_wish_product")
public class WishProduct {
    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    @TableField(value = "productId")
    Long productId;

    @TableField(value = "userId")
    Long wishId;
}
