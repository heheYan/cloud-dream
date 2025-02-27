package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.dto.AbstractBasicDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.Role}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends AbstractBasicDTO {
    String roleName;
    String description;
}