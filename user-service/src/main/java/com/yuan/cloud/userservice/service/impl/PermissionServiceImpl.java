package com.yuan.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.userservice.entity.Permission;
import com.yuan.cloud.userservice.service.PermissionService;
import com.yuan.cloud.userservice.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author YhhWork
* @description 针对表【s_permission(权限表)】的数据库操作Service实现
* @createDate 2025-02-25 19:10:29
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




