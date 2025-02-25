package com.yuan.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.userservice.entity.UserRole;
import com.yuan.cloud.userservice.service.UserRoleService;
import com.yuan.cloud.userservice.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author YhhWork
* @description 针对表【s_user_role(用户角色关联表)】的数据库操作Service实现
* @createDate 2025-02-25 19:10:29
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




