package com.yowayimono.order_food.core.entity;

public enum ThingStatus {
    ON_SHELF("上架"),
    OFF_SHELF("下架");

    private final String value;

    ThingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
