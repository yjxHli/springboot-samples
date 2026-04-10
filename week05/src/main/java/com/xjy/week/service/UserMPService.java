package com.xjy.week.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjy.week.entity.User;
import com.xjy.week.mapper.UserMPMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yjx
 * @date 2026/4/2
 * @description
 */

@Service
@RequiredArgsConstructor
public class UserMPService {
    private final UserMPMapper userMPMapper;
    public Page<User> page(String username, Integer pageNum, Integer pageSize) {
        // 1. 构造分页参数：pageNum（页码，从1开始）、pageSize（每页条数）
        Page<User> page = Page.of(pageNum, pageSize);
        // 2. 构造条件构造器：LambdaQueryWrapper（类型安全，避免字段名写错）
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 条件：用户名不为空时，模糊查询（第一个参数为条件，满足才拼接）
        wrapper.like(username != null && !username.isEmpty(), User::getUsername, username);
        // 3. 调用BaseMapper的selectPage方法，实现条件分页
        return userMPMapper.selectPage(page, wrapper);
    }
        public int add(User user){
            return userMPMapper.insert(user);


    }

    public int delete(Long id) {
        return userMPMapper.deleteById(id);
    }
}
