package com.xjy.week02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //全参构造器
@NoArgsConstructor  //无参构造器
@Builder

public class Phone {
    private String band;
    private Double price;
    private String color;


}
