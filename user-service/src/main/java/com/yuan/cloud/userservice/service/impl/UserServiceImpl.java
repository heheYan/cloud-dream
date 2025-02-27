package com.yuan.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.userservice.entity.User;
import com.yuan.cloud.userservice.mapper.UserMapper;
import com.yuan.cloud.userservice.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author YhhWork
 * @description 针对表【s_user(用户信息表)】的数据库操作Service实现
 * @createDate 2025-02-25 19:10:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public User getUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        return baseMapper.selectOne(queryWrapper);
    }
}




