package com.kc.pb;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class FastStart {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        PeopleInfo p1 = PeopleInfo.newBuilder().
                setAge(20).setName("叶秋寒")
                .build();
        //序列化
        byte[] bytes = p1.toByteArray();
        //二进制序列
        System.out.println("序列化结果:" + Arrays.toString(bytes));
        //反序列化
        PeopleInfo p2 = PeopleInfo.parseFrom(bytes);
        System.out.println("反序列化结果:");
        System.out.println("姓名:" + p2.getName());
        System.out.println("年龄:" + p2.getAge());
    }
}
