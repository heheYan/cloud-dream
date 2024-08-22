package com.hedit.acecenter.sysuser.service;

import com.hedit.acecenter.sysuser.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Mr.Y
 * Created on 2024-08-20 20:10
 * @description
 */
@SpringBootTest
class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void findByMobileOrEmail() {
        SysUser sysUser = sysUserService.findbyMobileOrEmail("18506126655");
        System.out.println(sysUser);
    }

    @Test
    public void save() {
        SysUser sysUser = new SysUser();
        sysUser.setMobile("18506126655");
        sysUser.setPassword(passwordEncoder.encode("123456"));
        sysUser.setNickName("管理员");
        sysUser.setName("闫贺贺");
        sysUser.setEmail("123456@qq.com");
        sysUser.setGender("男");
        sysUser.setVip(true);
        sysUser.setVipLevel(1);
        sysUser.setVipType("1");

        sysUserService.save(sysUser);
    }
}