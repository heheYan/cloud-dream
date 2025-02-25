package com.yuan.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.userservice.entity.User;
import com.yuan.cloud.userservice.service.UserService;
import com.yuan.cloud.userservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author YhhWork
* @description 针对表【s_user(用户信息表)】的数据库操作Service实现
* @createDate 2025-02-25 19:10:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




