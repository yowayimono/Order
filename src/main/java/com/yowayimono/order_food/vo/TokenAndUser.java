package com.yowayimono.order_food.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenAndUser {
    private String token;
    private String user;
}
