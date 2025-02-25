package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Role}
 */
@Value
public class RoleDTO implements Serializable {
    String roleName;
    String description;
    Long id;
    LocalDateTime gmtCreate;
    LocalDateTime gmtModified;
    Boolean deleted;
}