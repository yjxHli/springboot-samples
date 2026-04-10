package com.xjy.week.controller;

import com.xjy.week.common.Result;
import com.xjy.week.entity.User;
import com.xjy.week.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yjx
 * @date 2026/4/2
 * @description
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "用户接口",description = "用户接口")
public class UserController {
    private final UserService userService;

    @PostMapping
    @Operation(summary = "新增用户", description = "新增用户接口")
    public Result<String> add(@RequestBody User user) {
        int row = userService.add(user);
        if (row != 1) {
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取用户信息", description = "获取用户信息接口")
    public Result<User> get(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }

    @GetMapping("/list")
    @Operation(summary = "获取用户列表", description = "获取用户列表接口")
    public Result<List<User>> list() {
        return Result.success(userService.list());
    }

    @PutMapping
    @Operation(summary = "更新用户", description = "更新用户接口")
    public Result<String> update(@RequestBody User user) {
        int row = userService.update(user);
        if (row != 1) {
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "删除用户接口")
    public Result<String> delete(@PathVariable Long id) {
        int row = userService.delete(id);
        if (row != 1) {
            return Result.error("删除失败");
        }
        return Result.success("删除成功");
    }

    @GetMapping("/search")
    @Operation(summary = "搜索用户", description = "搜索用户接口")
    public List<User> search(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer minAge) {
        return userService.search(username, minAge);
    }

}