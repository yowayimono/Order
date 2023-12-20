package com.yowayimono.order_food.enitiy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("or_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "nikename")
    private String nickname;

    @TableField(value ="phone")
    private String phone;

    @TableField(value ="email")
    private String email;

    @TableField(value ="description")
    private String description;


    @TableField(value ="role")
    private String role;

    @TableField(value ="status")
    private String status;

    @TableField(value ="score")
    private BigDecimal score;

    @TableField(value ="avatar")
    private String avatar;

    @TableField(exist = false)
    private MultipartFile avatarFile;

    @TableField(value = "createTime")
    private LocalDateTime createTime;

    @TableField(value = "deletetime")
    private LocalDateTime deletetime;
}
