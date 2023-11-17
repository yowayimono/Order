package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String email;

    private String description;

    @NotNull
    private String role;

    private String status;

    private BigDecimal score;

    private String avatar;

    private String token;

    @TableField(value = "createTime")
    private LocalDateTime createTime;

    @TableField(value = "pushEmail")
    private String pushEmail;

    @TableField(value = "pushSwitch")
    private String pushSwitch;


}