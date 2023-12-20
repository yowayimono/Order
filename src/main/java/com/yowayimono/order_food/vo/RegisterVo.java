package com.yowayimono.order_food.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterVo {

    // 电话
    // private String mobile;

    // 用户名 唯一 and ！= 昵称
    private String username;

    // 密码
    private String password;
}
