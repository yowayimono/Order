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
@TableName("or_thing_tag")
public class ThingTag {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "thingId")
    private Long thingId;

    @TableField(value = "tagId")
    private Long tagId;

}