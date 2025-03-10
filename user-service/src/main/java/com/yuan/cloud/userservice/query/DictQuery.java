package com.yuan.cloud.userservice.query;

import com.yuan.cloud.core.annotation.YuanQueryType;
import com.yuan.cloud.core.enums.QueryTypeEnum;
import com.yuan.cloud.core.query.BasicQuery;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictQuery extends BasicQuery {
    /**
     * 字典名称
     */
    @YuanQueryType(type = QueryTypeEnum.LIKE)
    private String dictName;
}
