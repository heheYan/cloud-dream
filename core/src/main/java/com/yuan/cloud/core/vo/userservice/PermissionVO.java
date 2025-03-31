package com.yuan.cloud.core.vo.userservice;

import com.yuan.cloud.core.vo.AbstractBasicVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionVO extends AbstractBasicVO {
    String permissionName;
    String permissionCode;
    String remark;
}
