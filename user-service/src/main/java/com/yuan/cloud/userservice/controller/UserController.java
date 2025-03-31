package com.yuan.cloud.userservice.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.LoginDTO;
import com.yuan.cloud.core.dto.userservice.UserDTO;
import com.yuan.cloud.core.enums.YuanStatusEnum;
import com.yuan.cloud.core.exception.YuanApiException;
import com.yuan.cloud.core.response.YuanR;
import com.yuan.cloud.core.vo.userservice.LoginResultVO;
import com.yuan.cloud.core.vo.userservice.RoleVO;
import com.yuan.cloud.core.vo.userservice.UserVO;
import com.yuan.cloud.userservice.entity.User;
import com.yuan.cloud.userservice.query.UserQuery;
import com.yuan.cloud.userservice.service.RoleService;
import com.yuan.cloud.userservice.service.UserRoleService;
import com.yuan.cloud.userservice.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据id查询用户信息，重写父方法，添加角色信息查询
     *
     * @param id 主键
     * @return
     */
    @Override
    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        UserVO userVO = super.findById(id);
        // 查询用户角色
        userVO.setRoles(BeanUtil.copyToList(userRoleService.findByUserId(id), RoleVO.class));
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

        return basicService.findByUsername(username);
    }

    /**
     * 绑定用户角色接口
     *
     * @return
     */
    @PostMapping("bindRole")
    public YuanR<List<Long>> bindRole(@RequestBody UserDTO dto) {
        User user = basicService.getById(dto.getId());
        if (user == null) {
            throw new YuanApiException(YuanStatusEnum.USER_NOT_FOUND);
        }
        // 绑定用户角色
        userRoleService.bindRole(dto);
        return YuanR.ok(dto.getRoleIds());
    }

    /**
     * 用户登录
     *
     * @param dto
     * @return
     */
    @PostMapping("login")
    public LoginResultVO login(@Validated @RequestBody LoginDTO dto) {
        UserDTO user = basicService.findByUsername(dto.getUsername());
        if (user == null) {
            throw new YuanApiException(YuanStatusEnum.USER_NOT_FOUND);
        }
        if (!DigestUtil.bcryptCheck(dto.getPassword(), user.getPassword())) {
            throw new YuanApiException(YuanStatusEnum.PASSWORD_ERROR);
        }
        return LoginResultVO.success("123", "123", "123");
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
