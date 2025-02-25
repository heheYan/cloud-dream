package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.UserRole}
 */
@Value
public class UserRoleDTO implements Serializable {
    Long userId;
    Long roleId;
    Long id;
}