package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.cloud.core.entity.AbstractBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息表
 *
 * @TableName s_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "s_user")
@Data
public class User extends AbstractBasicEntity {
    /**
     * 用户名(登录账号)
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像（链接地址）
     */
    private String avatar;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号(考虑加密保存)
     */
    private String identityNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别，对应代码项[性别]
     */
    private String gender;

    /**
     * 是否锁定，0-否，1-是
     */
    @TableField(value = "is_locked", fill = FieldFill.INSERT)
    private Boolean locked;

    /**
     * 是否禁用，0-否，1-是
     */
    @TableField(value = "is_disabled", fill = FieldFill.INSERT)
    private Boolean disabled;
}