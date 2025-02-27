package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.dto.AbstractBasicDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Dict}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictDTO extends AbstractBasicDTO {
    String dictName;
    String remark;
    Integer sortOrder;
}