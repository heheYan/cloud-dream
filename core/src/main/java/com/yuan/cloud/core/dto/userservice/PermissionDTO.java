package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Permission}
 */
@Value
public class PermissionDTO implements Serializable {
    String permissionName;
    String permissionCode;
    String permissionType;
    String description;
    Long id;
    LocalDateTime gmtCreate;
    LocalDateTime gmtModified;
    Boolean deleted;
}