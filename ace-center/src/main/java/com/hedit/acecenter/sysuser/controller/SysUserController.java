package com.hedit.acecenter.sysuser.controller;

import com.hedit.acecenter.response.AHeResult;
import com.hedit.acecenter.sysuser.entity.SysUser;
import com.hedit.acecenter.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Y
 * Created on 2024-08-20 19:58
 * @description 用户信息接口
 */
@RestController("sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("getUserInfo/{id}")
    public AHeResult getUserInfo(@PathVariable("id") Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return AHeResult.success("用户信息查询成功！", sysUser);
    }

    @GetMapping("getUserInfoByName/{mobile}")
    public AHeResult getUserInfoByMobile(@PathVariable("mobile") String mobile) {
        SysUser sysUser = sysUserService.findbyMobileOrEmail(mobile);
        return AHeResult.success("用户信息查询成功！", sysUser);
    }

    @GetMapping("getUserInfoList")
    public AHeResult getUserInfoList() {
        return AHeResult.success("用户信息查询成功！", sysUserService.list());
    }

    @PostMapping("addUserInfo")
    public AHeResult addUserInfo(SysUser sysUser) {
        sysUserService.save(sysUser);
        return AHeResult.success("用户信息添加成功！");
    }

}
