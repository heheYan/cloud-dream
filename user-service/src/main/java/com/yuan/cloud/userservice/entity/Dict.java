package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.cloud.core.entity.AbstractBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据字典表
 *
 * @TableName s_dict
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "s_dict")
@Data
public class Dict extends AbstractBasicEntity {
    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典项描述
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sortOrder;
}