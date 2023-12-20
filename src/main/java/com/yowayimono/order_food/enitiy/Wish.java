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
@TableName("or_wish")
public class Wish { //心愿单
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @TableField(value = "name")
    private String wishname;

    //@TableField(value = "ProductId")
    //private Long ProductId;

    @TableField(value = "userId")
    private Long userId;
}