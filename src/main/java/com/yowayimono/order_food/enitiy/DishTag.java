package com.yowayimono.order_food.enitiy;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_dishtag")
public class DishTag {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull
    @TableField(value = "title")
    private String title;

    @NotNull
    @TableField(value = "description")
    private String description;


    @NotNull
    @TableField(value = "createtime")
    private LocalDateTime createtime;

    @NotNull
    @TableField(value = "deletetime")
    private  LocalDateTime deletetime;
}
