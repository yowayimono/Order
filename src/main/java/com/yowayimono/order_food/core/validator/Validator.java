package com.yowayimono.order_food.core.validator;

public class Validator {
    public static boolean isValidUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        // 用户名只能是字母和数字组成，开头必须是字母
        return username.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        // 密码长度在 18 到 20 之间，且不能包含空格
        return password.length() >= 8 && password.length() <= 20 && !password.contains(" ");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        // 电话号码以 "+86" 开头，后面跟着 11 位数字
        return phoneNumber.matches("^\\+86\\d{11}$");
    }
}
