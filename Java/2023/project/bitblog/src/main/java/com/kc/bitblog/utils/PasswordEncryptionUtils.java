package com.kc.bitblog.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class PasswordEncryptionUtils {
    /**
     * 生成加盐密码
     *
     * @param password
     * @return
     */
    public static String encypt(String password) {
        String salt = UUID.randomUUID().toString().replace("-", "");
        String saltPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        String finalPassword = salt + "$" + saltPassword;
        return finalPassword;
    }

    public static String encypt(String password, String salt) {
        String saltPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        String finalPassword = salt + "$" + saltPassword;
        return finalPassword;
    }

    public static boolean check(String inputPassword, String finalPassword) {
        if (StringUtils.hasLength(inputPassword) && StringUtils.hasLength(finalPassword)
                && finalPassword.length() == 65) {
            String salt = finalPassword.split("\\$")[0];
            String confirmPassword =encypt(inputPassword,salt);
            return finalPassword.equals(confirmPassword);
        }
        return false;
    }
}
