package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.dto.AbstractBasicDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Router}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RouterDTO extends AbstractBasicDTO {
    Long parentId;
    String name;
    String path;
    String component;
    String redirect;
    String type;
    Integer cached;
    Integer disabled;
    Integer sortOrder;
}