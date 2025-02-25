package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.cloud.core.entity.AbstractBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 路由信息表
 *
 * @TableName s_router
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "s_router")
@Data
public class Router extends AbstractBasicEntity {
    /**
     * 父路由主键，根目录为null
     */
    private Long parentId;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 重定向地址
     */
    private String redirect;

    /**
     * 路由类型，菜单or按钮
     */
    private String type;

    /**
     * 元信息
     */
    private Object meta;

    /**
     * 是否缓存，1-是，0-否
     */
    private Integer cached;

    /**
     * 是否禁用，1-是，0-否
     */
    private Integer disabled;

    /**
     * 排序字段
     */
    private Integer sortOrder;
}