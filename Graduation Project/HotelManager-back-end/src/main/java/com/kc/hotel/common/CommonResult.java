package com.kc.hotel.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
// @AllArgsConstructor 自动生成包含所有字段的构造函数。
@AllArgsConstructor
// @NoArgsConstructor 自动生成无参构造函数。
@NoArgsConstructor
public class CommonResult<T> {

    // Integer code 用于表示操作的状态码或结果码。
    private Integer code;

    // String message 包含有关结果或操作的描述性消息。
    private String message;

    // 泛型类型 T 用于表示与结果关联的数据。
    private T data;
}