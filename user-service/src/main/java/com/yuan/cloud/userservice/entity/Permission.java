package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.cloud.core.entity.AbstractBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限表
 *
 * @TableName s_permission
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "s_permission")
@Data
public class Permission extends AbstractBasicEntity {
    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限编码
     */
    private String permissionCode;

    /**
     * 权限类型，代码项【权限类型】
     */
    private String permissionType;

    /**
     * 权限描述
     */
    private String description;
}