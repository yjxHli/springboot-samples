package com.xjy.springboothello.vo;

/**
 * 通用返回结果封装类
 * @param <T> 数据类型
 */
public class ResultVO<T> {
    /**
     * 响应状态码
     */
    private int code;
    
    /**
     * 响应消息
     */
    private String msg;
    
    /**
     * 响应数据
     */
    private T data;

    // 无参构造函数
    public ResultVO() {
    }

    // 全参构造函数
    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // getter 和 setter 方法
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