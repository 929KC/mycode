package com.kc.bot.job.util;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.*;


public class CronBase64Encoder {


    public static void main1(String[] args) {
        String cronExpression = "0 */1 * * * ?";
        String base64Encoded = encodeToBase64(cronExpression);
        System.out.println("原始 cron 表达式：" + cronExpression);
        System.out.println("Base64 编码后：" + base64Encoded);
    }

    /**
     * 将 cron 表达式编码成 Base64 字符串。
     *
     * @param cronExpression cron 表达式
     * @return Base64 编码后的字符串
     */
    private static String encodeToBase64(String cronExpression) {
        byte[] bytes = cronExpression.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(bytes);
    }
}
