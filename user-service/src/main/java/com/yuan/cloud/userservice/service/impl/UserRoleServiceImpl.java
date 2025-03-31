package com.yuan.cloud.userservice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.core.dto.userservice.RoleDTO;
import com.yuan.cloud.core.dto.userservice.UserDTO;
import com.yuan.cloud.userservice.entity.UserRole;
import com.yuan.cloud.userservice.mapper.RoleMapper;
import com.yuan.cloud.userservice.mapper.UserRoleMapper;
import com.yuan.cloud.userservice.service.UserRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YhhWork
 * @description 针对表【s_user_role(用户角色关联表)】的数据库操作Service实现
 * @createDate 2025-02-25 19:10:29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Resource
    RoleMapper roleMapper;

    /**
     * 根据用户ID查询角色列表
     *
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<RoleDTO> findByUserId(Long userId) {
        List<UserRole> userRoles = baseMapper.selectList(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId));
        if (CollUtil.isNotEmpty(userRoles)) {
            List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).toList();
            return BeanUtil.copyToList(roleMapper.selectByIds(roleIds), RoleDTO.class);
        }
        return new ArrayList<>();
    }

    @Override
    public void removeByUserId(Long userId) {
        baseMapper.delete(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, userId));
    }

    @Override
    public void bindRole(UserDTO dto) {
        // 删除用户角色
        removeByUserId(dto.getId());
        // 添加新角色
        if (CollUtil.isNotEmpty(dto.getRoleIds())) {
            List<UserRole> userRoles = dto.getRoleIds().stream().map(roleId -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(dto.getId());
                userRole.setRoleId(roleId);
                return userRole;
            }).toList();
            baseMapper.insertOrUpdate(userRoles);
        }
    }
}




