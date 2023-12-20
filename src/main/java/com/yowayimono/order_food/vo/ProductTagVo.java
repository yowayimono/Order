package com.yowayimono.order_food.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTagVo {
    @TableField(value = "ProductId")
    private Long ProductId;

    @TableField(value = "tagId")
    private Long tagId;
}
