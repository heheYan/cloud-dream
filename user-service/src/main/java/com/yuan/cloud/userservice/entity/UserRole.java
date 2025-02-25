package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关联表
 *
 * @TableName s_user_role
 */
@TableName(value = "s_user_role")
@Data
public class UserRole implements Serializable {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 角色主键
     */
    private Long roleId;
}