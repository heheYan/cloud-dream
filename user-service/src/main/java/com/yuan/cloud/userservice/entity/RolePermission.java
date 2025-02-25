package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限关联表
 *
 * @TableName s_role_permission
 */
@TableName(value = "s_role_permission")
@Data
public class RolePermission implements Serializable {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 角色主键
     */
    private Long roleId;

    /**
     * 权限主键
     */
    private Long permissionId;
}