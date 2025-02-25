package com.yuan.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.userservice.entity.Role;
import com.yuan.cloud.userservice.service.RoleService;
import com.yuan.cloud.userservice.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author YhhWork
* @description 针对表【s_role(角色信息表)】的数据库操作Service实现
* @createDate 2025-02-25 19:10:29
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




