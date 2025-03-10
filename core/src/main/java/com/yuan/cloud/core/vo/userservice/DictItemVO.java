package com.yuan.cloud.core.vo.userservice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yuan.cloud.core.vo.AbstractBasicVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictItemVO extends AbstractBasicVO {
    @JsonSerialize(using = ToStringSerializer.class)
    Long dictId;
    String itemLabel;
    String itemCode;
    String remark;
    Integer sortOrder;
}
