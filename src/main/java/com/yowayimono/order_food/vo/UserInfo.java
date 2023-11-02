package com.yowayimono.order_food.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String username;

    private String nickname;

    private String mobile;

    private String email;

    private String description;


    private BigDecimal score;

    private String avatar;

    private String token;

    private String pushEmail;

    private String pushSwitch;

}
