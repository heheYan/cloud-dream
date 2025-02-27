package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.dto.AbstractBasicDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Permission}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionDTO extends AbstractBasicDTO {
    String permissionName;
    String permissionCode;
    String permissionType;
    String description;
}