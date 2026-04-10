package com.xjy.week04.controller;

import com.xjy.week04.common.Result;
import com.xjy.week04.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/info")
    public Result<User> getUserInfo(){
        User user = new User();
        user.setId(12314141414141123L);
        user.setUsername("springmvc-student");
        user.setCreateTime(LocalDateTime.now());
        return Result.success(user);
    }
}
