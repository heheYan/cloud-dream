package com.yuan.cloud.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.cloud.userservice.entity.User;

/**
 * @author YhhWork
 * @description 针对表【s_user(用户信息表)】的数据库操作Service
 * @createDate 2025-02-25 19:10:29
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);
}
