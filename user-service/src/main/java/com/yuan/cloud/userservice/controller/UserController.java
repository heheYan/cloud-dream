package com.yuan.cloud.userservice.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.UserDTO;
import com.yuan.cloud.core.vo.UserVO;
import com.yuan.cloud.userservice.entity.User;
import com.yuan.cloud.userservice.query.UserQuery;
import com.yuan.cloud.userservice.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制器
 */
@RestController
@RequestMapping("user")
public class UserController extends BasicController<UserService, User, UserDTO, UserVO, UserQuery> {

    public UserController(UserService userService) {
        super(userService);
    }

    @Override
    public UserVO save(@Validated @RequestBody UserDTO dto) {
        if (StrUtil.isNotEmpty(dto.getPassword())) {
            dto.setPassword(DigestUtil.bcrypt(dto.getPassword()));
        }
        return super.save(dto);
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
