package com.kc.bitblog.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResult {
    private Integer code;
    private String message;

    private Object data;

    /**
     * 操作成功返回的结果
     */
    public static HttpResult success(Object data) {
        HttpResult result = new HttpResult();
        result.setCode(200);
        result.setMessage("");
        result.setData(data);
        return result;
    }

    public static HttpResult success(int code, Object data) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMessage("");
        result.setData(data);
        return result;
    }

    public static HttpResult success(int code, String msg, Object data) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    /**
     * 返回失败结果
     */
    public static HttpResult fail(int code, String msg) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }

    public static HttpResult fail(int code, String msg, Object data) {
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}
