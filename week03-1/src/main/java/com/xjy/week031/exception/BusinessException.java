package com.xjy.week031.exception;

import lombok.Getter;

/**
 * @author yjx
 * @date 2026/3/30
 * @description
 */
public class BusinessException extends RuntimeException{
    @Getter
    private Integer code;

    private final String message;
    public BusinessException(String message) {
        super(message);
        this.message = message;
    }
    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
