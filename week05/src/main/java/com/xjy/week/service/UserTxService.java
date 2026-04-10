package com.xjy.week.service;

import com.xjy.week.entity.User;
import com.xjy.week.mapper.UserMapper;
import jdk.jfr.TransitionFrom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @author yjx
 * @date 2026/4/2
 * @description
 */

@Service
@RequiredArgsConstructor
public class UserTxService {

    private final UserMapper userMapper;

    @Transactional
    public void addTwoUsers(User user1, User user2) {
        userMapper.insert(user1);
        if (user2.getUsername() == null || user2.getUsername().isEmpty()){
            throw new RuntimeException("用户2姓名不能为空，事务回滚");
        }
        userMapper.insert(user2);
    }
}
