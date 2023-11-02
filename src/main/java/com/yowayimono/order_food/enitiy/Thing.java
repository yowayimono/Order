package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_thing")
public class Thing {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String title;

    private String nickname;

    private String sex;

    private String address;

    private String cover;

    private String description;

    private BigDecimal price;

    private String status;

    @TableField(value = "createTime")
    private LocalDateTime createTime;

    private BigDecimal score;

    private Integer pv;

    @TableField(value = "recommendCount")
    private Integer recommendCount;

    @TableField(value = "wishCount")
    private Integer wishCount;

    @TableField(value = "collectCount")
    private Integer collectCount;

    @TableField(value = "classificationId")
    private Long classificationId;


}