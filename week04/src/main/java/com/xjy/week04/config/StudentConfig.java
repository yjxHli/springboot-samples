package com.xjy.week04.config;

import com.xjy.week04.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public Student student() {
        Student student = new Student();
        student.setId(2505223123L);
        student.setName("yjx");
        student.setAge(23);
        return student;
    }
}
