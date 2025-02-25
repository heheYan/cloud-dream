package com.yuan.cloud.userservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuan.cloud.core.entity.AbstractBasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典子项信息表
 *
 * @TableName s_dict_item
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "s_dict_item")
@Data
public class DictItem extends AbstractBasicEntity {
    /**
     * 关联字典主项id
     */
    private Long dictId;

    /**
     * 字典项名称
     */
    private String itemLabel;

    /**
     * 字典项值
     */
    private String itemCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sortOrder;
}