package com.yowayimono.order_food.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


    @Component
    public class Encryption {


        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        public String sha256(String input) {
            return passwordEncoder.encode(input);
        }
        public boolean verifyPassword(String rawPassword, String encodedPassword) {
            return passwordEncoder.matches(rawPassword, encodedPassword);
        }


    }
