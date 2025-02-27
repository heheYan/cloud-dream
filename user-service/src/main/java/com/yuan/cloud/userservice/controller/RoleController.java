package com.yuan.cloud.userservice.controller;

import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.RoleDTO;
import com.yuan.cloud.core.vo.RoleVO;
import com.yuan.cloud.userservice.entity.Role;
import com.yuan.cloud.userservice.query.RoleQuery;
import com.yuan.cloud.userservice.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色管理
 */
@RestController
@RequestMapping("role")
public class RoleController extends BasicController<RoleService, Role, RoleDTO, RoleVO, RoleQuery> {
    public RoleController(RoleService roleService) {
        super(roleService);
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    protected Class<RoleVO> getVoClass() {
        return RoleVO.class;
    }
}
