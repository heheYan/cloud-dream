package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.RolePermission}
 */
@Value
public class RolePermissionDTO implements Serializable {
    Long id;
    Long roleId;
    Long permissionId;
}