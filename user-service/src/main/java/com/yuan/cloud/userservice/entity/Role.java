package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.cloud.core.entity.AbstractBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色信息表
 *
 * @TableName s_role
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "s_role")
@Data
public class Role extends AbstractBasicEntity {
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编号
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String remark;

    /**
     * 是否禁用，1-是，0-否
     */
    @TableField(value = "is_disabled", fill = FieldFill.INSERT)
    private Boolean disabled;
}