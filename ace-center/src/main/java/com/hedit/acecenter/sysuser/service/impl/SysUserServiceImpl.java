package com.hedit.acecenter.sysuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hedit.acecenter.sysuser.entity.SysUser;
import com.hedit.acecenter.sysuser.service.SysUserService;
import com.hedit.acecenter.sysuser.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author YhhWork
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2024-08-20 19:57:29
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Override
    public SysUser findbyMobileOrEmail(String mobileOrEmail) {
        return baseMapper.selectOne(new QueryChainWrapper<>(SysUser.class).eq("mobile", mobileOrEmail).or().eq("email", mobileOrEmail));
    }
}




