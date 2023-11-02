package com.yowayimono.order_food.enitiy;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_tag")
public class Tag {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    private String title;
    private Timestamp createtime;
}
