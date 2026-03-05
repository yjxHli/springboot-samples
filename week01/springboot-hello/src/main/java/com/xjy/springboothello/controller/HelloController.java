package com.xjy.springboothello.controller;

import com.xjy.springboothello.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello接口控制器
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * Hello接口方法
     * @return 统一格式的欢迎信息
     */
    @GetMapping("/hello")
    public ResultVO<String> hello() {
        // 按照规格文档要求返回固定格式的响应
        return new ResultVO<>(200, "success", "Hello Spring Boot");
    }
}