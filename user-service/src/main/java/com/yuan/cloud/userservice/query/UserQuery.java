package com.yuan.cloud.userservice.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuan.cloud.core.annotation.YuanQueryType;
import com.yuan.cloud.core.enums.QueryTypeEnum;
import com.yuan.cloud.core.query.BasicQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author YuAN
 * Created on 2025-02-27 18:28
 * @description 用户管理查询对象
 */
@Getter
@Setter
public class UserQuery extends BasicQuery {
    @YuanQueryType(type = QueryTypeEnum.LIKE)
    private String username;

    @YuanQueryType(type = QueryTypeEnum.LIKE)
    private String mobile;

    @YuanQueryType(type = QueryTypeEnum.LIKE)
    @JsonProperty("nickName")
    private String nick_name;

    @YuanQueryType(type = QueryTypeEnum.EQUAL)
    @JsonProperty("disabled")
    private Boolean is_disabled;

    @JsonProperty("createTime")
    @YuanQueryType(type = QueryTypeEnum.BETWEEN)
    private String[] gmt_create;
}
