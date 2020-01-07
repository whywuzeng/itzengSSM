package com.itzeng.ssm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm
 */

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

//    @Test
//    public void test12(){
//        String password = "itzeng";
//        String pwd = encodePassword(password);
//        System.out.println(pwd);
//    }

    public static void main(String[] args) {
    }
}
