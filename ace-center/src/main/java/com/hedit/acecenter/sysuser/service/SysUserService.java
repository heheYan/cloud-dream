package com.hedit.acecenter.sysuser.service;

import com.hedit.acecenter.sysuser.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author YhhWork
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2024-08-20 19:57:29
*/
public interface SysUserService extends IService<SysUser> {

    SysUser findbyMobileOrEmail(String mobileOrEmail);

}
