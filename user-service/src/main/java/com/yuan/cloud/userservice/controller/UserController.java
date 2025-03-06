package com.yuan.cloud.userservice.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.UserDTO;
import com.yuan.cloud.core.enums.YuanStatusEnum;
import com.yuan.cloud.core.exception.YuanApiException;
import com.yuan.cloud.core.vo.RoleVO;
import com.yuan.cloud.core.vo.UserVO;
import com.yuan.cloud.userservice.entity.User;
import com.yuan.cloud.userservice.entity.UserRole;
import com.yuan.cloud.userservice.query.UserQuery;
import com.yuan.cloud.userservice.service.RoleService;
import com.yuan.cloud.userservice.service.UserRoleService;
import com.yuan.cloud.userservice.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("user")
public class UserController extends BasicController<UserService, User, UserDTO, UserVO, UserQuery> {
    final UserRoleService userRoleService;
    final RoleService roleService;

    public UserController(UserService userService, UserRoleService userRoleService, RoleService roleService) {
        super(userService);
        this.userRoleService = userRoleService;
        this.roleService = roleService;
    }

    @Override
    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        UserVO userVO = super.findById(id);
        List<RoleVO> roleVOS = new ArrayList<>();
        // 查询用户角色
        List<UserRole> userRoles = userRoleService.list(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, id));
        if (CollUtil.isNotEmpty(userRoles)) {
            List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).toList();
            roleVOS = BeanUtil.copyToList(roleService.listByIds(roleIds), RoleVO.class);
        }
        userVO.setRoles(roleVOS);
        return userVO;
    }

    /**
     * 保存用户信息
     *
     * @param dto
     * @return
     */
    @Override
    public UserVO save(@Validated @RequestBody UserDTO dto) {
        if (StrUtil.isNotEmpty(dto.getPassword())) {
            dto.setPassword(DigestUtil.bcrypt(dto.getPassword()));
        }
        return super.save(dto);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户dto对象
     */
    @GetMapping("findByUsername/{username}")
    public UserDTO findByUsername(@PathVariable("username") String username) {
        User user = basicService.findByUsername(username);
        if (user == null) {
            throw new YuanApiException(YuanStatusEnum.USER_NOT_FOUND);
        }
        return BeanUtil.copyProperties(user, UserDTO.class);
    }

    /**
     * 绑定用户角色接口
     *
     * @return
     */
    @PostMapping("bindRole")
    public UserVO bindRole(@RequestBody UserDTO dto) {
        User user = basicService.getById(dto.getId());
        if (user == null) {
            throw new YuanApiException(YuanStatusEnum.USER_NOT_FOUND);
        }
        // 删除用户角色
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", user.getId());
        userRoleService.removeByMap(map);
        // 添加新角色
        if (CollUtil.isNotEmpty(dto.getRoleIds())) {
            List<UserRole> userRoles = dto.getRoleIds().stream().map(roleId -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(dto.getId());
                userRole.setRoleId(roleId);
                return userRole;
            }).toList();
            userRoleService.saveOrUpdateBatch(userRoles);
        }
        return BeanUtil.copyProperties(user, UserVO.class);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserVO> getVoClass() {
        return UserVO.class;
    }
}
