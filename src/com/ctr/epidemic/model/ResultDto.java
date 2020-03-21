package com.ctr.epidemic.model;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 9:53
 * ajax传输对象
 */
public class ResultDto<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
