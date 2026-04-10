package com.xjy.week04.exception;


import lombok.Getter;

/**
 * @author yjx
 * @date 2026/3/27
 * @description
 */

@Getter
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(String message){
        super(message);
        this.code = 500;
    }

    public BusinessException(int code,String message) {
        super(message);
        this.code = code;
    }
}
