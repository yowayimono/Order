package com.yowayimono.order_food.core.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


public class EncryptionUtils {

    static Encryption passwordEncoder=new Encryption();

    public static String sha256(String input) {
        return passwordEncoder.sha256(input);
    }

    public static boolean checkPassWord(String input,String pass) {
        return passwordEncoder.passwordEncoder.matches(input,pass);
    }

}