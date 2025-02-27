package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.dto.AbstractBasicDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.DictItem}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemDTO extends AbstractBasicDTO {
    Long dictId;
    String itemLabel;
    String itemCode;
    String remark;
    Integer sortOrder;
}