package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_address")
public class AddressInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "addrinfo")
    private String addrinfo;


    @TableField(value = "phone")
    private String phone;


    @TableField(value = "title")
    private String title;

    @TableField(value = "deleteTime")
    private LocalDateTime deleteTime;


    @TableField(value = "description")
    private String description;


    @TableField(value = "createTime")

    private LocalDateTime createTime;

    @TableField(value = "userId")

    private Long userId;

}
