package com.yuan.cloud.userservice.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuan.cloud.core.annotation.YuanQueryType;
import com.yuan.cloud.core.enums.QueryTypeEnum;
import com.yuan.cloud.core.query.BasicQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mr.Y
 * Created on 2024-12-17 19:47
 * @description 角色查询条件
 */
@Getter
@Setter
public class RoleQuery extends BasicQuery {
    @YuanQueryType(type = QueryTypeEnum.LIKE)
    @JsonProperty("roleName")
    private String role_name;

    @YuanQueryType(type = QueryTypeEnum.LIKE)
    @JsonProperty("roleCode")
    private String role_code;

    @YuanQueryType(type = QueryTypeEnum.EQUAL)
    @JsonProperty("disabled")
    private Boolean is_disabled;
}
