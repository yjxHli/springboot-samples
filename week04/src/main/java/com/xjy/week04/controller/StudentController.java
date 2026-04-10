package com.xjy.week04.controller;

import com.xjy.week04.config.StudentConfig;
import com.xjy.week04.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student student1 = context.getBean("student", Student.class);

        student1.Message();

    }
}
