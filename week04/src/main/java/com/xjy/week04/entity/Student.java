package com.xjy.week04.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;

    public void Message(){
        System.out.println("学号："+id+", 姓名："+name+", 年龄："+age);
    }
}
