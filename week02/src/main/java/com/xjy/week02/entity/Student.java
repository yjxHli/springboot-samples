package com.xjy.week02.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student {
    private Long id;
    private String name;
    //性别 枚举类型 后续自己搞一下
    private Gender gender;
    private LocalDate birthday;
    private Phone phone;


}
