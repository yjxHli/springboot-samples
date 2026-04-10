package com.xjy.week.service;

import com.xjy.week.entity.User;
import com.xjy.week.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yjx
 * @date 2026/4/2
 * @description
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public int add(User user) {
        int result = userMapper.insert(user);
        user.setCreateTime(java.time.LocalDateTime.now());
        System.out.println(user);
        return result;
    }

    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public java.util.List<User> list() {
        return userMapper.selectList();
    }

    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public List<User> search(String username, Integer minAge) {
        return userMapper.selectByCondition(username, minAge);
    }
}