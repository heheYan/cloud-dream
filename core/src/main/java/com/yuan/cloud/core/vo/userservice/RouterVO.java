package com.yuan.cloud.core.vo.userservice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yuan.cloud.core.vo.AbstractBasicVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouterVO extends AbstractBasicVO {
    @JsonSerialize(using = ToStringSerializer.class)
    Long parentId;
    String name;
    String path;
    String component;
    String redirect;
    String type;
    Boolean cached;
    Boolean disabled;
    Boolean sortOrder;
}
