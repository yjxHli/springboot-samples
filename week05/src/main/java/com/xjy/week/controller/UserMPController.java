package com.xjy.week.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjy.week.common.Result;
import com.xjy.week.entity.User;
import com.xjy.week.service.UserMPService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author yjx
 * @date 2026/4/2
 * @description
 */

@RestController
@RequestMapping("/api/user/mp")
@RequiredArgsConstructor
@Tag(name = "MP接口",description = "MP接口")
public class UserMPController {
    private final UserMPService userMPService;

    @GetMapping("/page")
    @Operation(summary = "查询用户", description = "分页查询接口")
    public Result<Page<User>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String username) {
        return Result.success(userMPService.page(username, pageNum, pageSize));
    }


    @PostMapping
    @Operation(summary = "新增用户", description = "新增用户接口")
    public Result<String> add(@RequestBody User user) {
        int row = userMPService.add(user);
        if (row <= 0) {
            return Result.error("MP 添加失败");
        }
        return Result.success("MP 添加成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "删除用户接口")
    public Result<String> delete(@PathVariable Long id) {
        int row = userMPService.delete(id);
        if (row <= 0){
            return Result.error("MP 删除失败");
        }
        return Result.success("MP 删除成功");
    }

}
