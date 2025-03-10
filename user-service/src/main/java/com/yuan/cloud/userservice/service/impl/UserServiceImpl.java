package com.yuan.cloud.userservice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.core.dto.userservice.RoleDTO;
import com.yuan.cloud.core.dto.userservice.UserDTO;
import com.yuan.cloud.core.enums.YuanStatusEnum;
import com.yuan.cloud.core.exception.YuanApiException;
import com.yuan.cloud.userservice.entity.User;
import com.yuan.cloud.userservice.entity.UserRole;
import com.yuan.cloud.userservice.mapper.UserMapper;
import com.yuan.cloud.userservice.service.RoleService;
import com.yuan.cloud.userservice.service.UserRoleService;
import com.yuan.cloud.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YhhWork
 * @description 针对表【s_user(用户信息表)】的数据库操作Service实现
 * @createDate 2025-02-25 19:10:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    final UserRoleService userRoleService;
    final RoleService roleService;

    public UserServiceImpl(UserRoleService userRoleService, RoleService roleService) {
        this.userRoleService = userRoleService;
        this.roleService = roleService;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public UserDTO findByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = baseMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new YuanApiException(YuanStatusEnum.USER_NOT_FOUND);
        }
        UserDTO dto = BeanUtil.copyProperties(user, UserDTO.class);
        // 查询用户角色
        List<UserRole> userRoles = userRoleService.list(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, user.getId()));
        if (CollUtil.isNotEmpty(userRoles)) {
            List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).toList();
            dto.setRoles(BeanUtil.copyToList(roleService.listByIds(roleIds), RoleDTO.class));
        }
        return dto;
    }
}




