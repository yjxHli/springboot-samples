package com.xjy.springboothealth.vo;

public class ResultVO<T> {
    // 响应状态码
    private int code;
    // 响应消息
    private String message;
    // 响应数据
    private T data;

    // 成功响应构造方法
    private ResultVO(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    // 失败响应构造方法
    private ResultVO(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    // 成功返回方法
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(data);
    }

    // 失败返回方法
    public static <T> ResultVO<T> fail(int code, String message) {
        return new ResultVO<>(code, message);
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}