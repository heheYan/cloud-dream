package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.DictItem}
 */
@Value
public class DictItemDTO implements Serializable {
    Long dictId;
    String itemLabel;
    String itemCode;
    String remark;
    Integer sortOrder;
    Long id;
    LocalDateTime gmtCreate;
    LocalDateTime gmtModified;
    Boolean deleted;
}