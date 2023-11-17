package com.yowayimono.order_food.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThingTagVo {
    @TableField(value = "thingId")
    private Long thingId;

    @TableField(value = "tagId")
    private Long tagId;
}
