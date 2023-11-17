package com.yowayimono.order_food.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageSelectAndUser {
    private Long pagesize;
    private Long offect;

    private Long id;
}
