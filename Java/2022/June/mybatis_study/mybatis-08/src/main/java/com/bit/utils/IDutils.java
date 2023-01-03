package com.bit.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 19:11
 */

public class IDutils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","9");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
