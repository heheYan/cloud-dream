package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Router}
 */
@Value
public class RouterDTO implements Serializable {
    Long parentId;
    String name;
    String path;
    String component;
    String redirect;
    String type;
    Integer cached;
    Integer disabled;
    Integer sortOrder;
    Long id;
    LocalDateTime gmtCreate;
    LocalDateTime gmtModified;
    Boolean deleted;
}