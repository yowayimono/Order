package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_visit_data")
public class VisitData {
    @TableId(value = "re_ip")
    private String ip;

    private Integer count;

    @TableField(exist = false)
    private Object additionalField; // 用于示例，可以根据需求添加其他字段


}