package com.yowayimono.order_food.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVo {
    private String mobile;
    private String username;
    private String password;
}
