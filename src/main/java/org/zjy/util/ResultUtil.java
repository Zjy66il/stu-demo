package org.zjy.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class ResultUtil<T> {
    private int code;

    private String msg;

    private T data;

    public ResultUtil() {
        super();
    }

    public ResultUtil(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static ResultUtil success(String msg) {
        return new ResultUtil(0, msg, null);
    }

    public static ResultUtil success(String msg, Object data) {
        return new ResultUtil(0, msg, data);
    }

    public static ResultUtil success(Object data) {
        return new ResultUtil(0, null, data);
    }

    public static ResultUtil fail(int code) {
        return new ResultUtil(code, null, null);
    }

    public static ResultUtil fail(int code, String msg) {
        return new ResultUtil(code, msg, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
