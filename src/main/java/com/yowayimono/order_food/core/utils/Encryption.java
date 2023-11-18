package com.yowayimono.order_food.core.utils;

import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.logging.StreamHandler;

import static org.apache.tomcat.util.net.SSLHostConfigCertificate.Type.RSA;


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
