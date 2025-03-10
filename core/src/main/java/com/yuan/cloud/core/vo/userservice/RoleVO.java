package com.yuan.cloud.core.vo.userservice;

import com.yuan.cloud.core.vo.AbstractBasicVO;
import lombok.Getter;
import lombok.Setter;

/**
 * VO for {@link com.yuan.cloud.userservice.entity.Role}
 */
@Getter
@Setter
public class RoleVO extends AbstractBasicVO {
    private String roleName;
    private String roleCode;
    private String remark;
    private Boolean disabled;
}
