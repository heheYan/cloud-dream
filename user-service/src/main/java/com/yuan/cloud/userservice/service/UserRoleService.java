package com.yuan.cloud.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.cloud.core.dto.userservice.RoleDTO;
import com.yuan.cloud.core.dto.userservice.UserDTO;
import com.yuan.cloud.userservice.entity.UserRole;

import java.util.List;

/**
 * @author YhhWork
 * @description 针对表【s_user_role(用户角色关联表)】的数据库操作Service
 * @createDate 2025-02-25 19:10:29
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 根据用户ID查询角色
     *
     * @param userId
     * @return
     */
    List<RoleDTO> findByUserId(Long userId);

    /**
     * 根据用户ID删除角色关联关系
     *
     * @param userId
     */
    void removeByUserId(Long userId);

    /**
     * 绑定角色
     *
     * @param dto
     */
    void bindRole(UserDTO dto);
}
