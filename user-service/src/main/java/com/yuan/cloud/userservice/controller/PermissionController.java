package com.yuan.cloud.userservice.controller;

import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.PermissionDTO;
import com.yuan.cloud.core.vo.userservice.PermissionVO;
import com.yuan.cloud.userservice.entity.Permission;
import com.yuan.cloud.userservice.query.PermissionQuery;
import com.yuan.cloud.userservice.service.PermissionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("permission")
public class PermissionController extends BasicController<PermissionService, Permission, PermissionDTO, PermissionVO, PermissionQuery> {
    public PermissionController(PermissionService baseService) {
        super(baseService);
    }

    @Override
    protected Class<Permission> getEntityClass() {
        return Permission.class;
    }

    @Override
    protected Class<PermissionVO> getVoClass() {
        return PermissionVO.class;
    }
}
