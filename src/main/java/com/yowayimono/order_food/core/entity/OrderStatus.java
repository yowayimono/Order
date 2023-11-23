package com.yowayimono.order_food.core.entity;

public enum OrderStatus {
    UNPAID("待支付"),
    PAID("已支付"),
    SHIPPED("已发货"),
    RECEIVED("已收货"),
    CANCELED("已取消");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // 自定义方法，将字符串转换为对应的枚举值
    public static OrderStatus fromValue(String value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }
}
