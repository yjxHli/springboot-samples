package com.xjy.week.controller;

import com.xjy.week.common.Result;
import com.xjy.week.entity.User;
import com.xjy.week.service.UserTxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yjx
 * @date 2026/4/2
 * @description
 */
@RestController
@RequestMapping("/api/user/tx")
@RequiredArgsConstructor
@Tag(name = "用户事务接口",description = "用户事务接口")
public class UserTxController {
    private final UserTxService userTxService;

    @PostMapping("/addTwo")
    @Operation(summary = "新增两个用户", description = "新增两个用户接口")
    public Result<String> addTwo(@RequestBody Map<String, User>map){
        User user1 = map.get("user1");
        User user2 = map.get("user2");
        userTxService.addTwoUsers(user1, user2);
        return Result.success("两个用户均新增成功");
    }

}
