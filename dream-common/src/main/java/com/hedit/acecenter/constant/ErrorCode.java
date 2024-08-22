package com.hedit.acecenter.constant;

import lombok.Getter;

/**
 * @author Mr.Y
 * Created on 2024-08-19 17:18
 * @description 系统内部错误码，编码规则：
 * 第1位：x 固定值
 * 第2位：1/2 错误级别
 * 第3-4位：业务系统编号
 * 第5-7位：错误码流水号
 */
@Getter
public enum ErrorCode {

    SUCCESS("成功", "x000000"),
    PARAM_ERROR("参数错误", "x000001"),
    USER_NOT_EXIST("用户不存在", "x000002"),
    USER_PASSWORD_ERROR("用户密码错误", "x000003"),
    USER_NOT_LOGIN("用户未登录", "x000004"),
    USER_NOT_AUTHORIZED("用户未授权", "x000005"),
    USER_NOT_ENABLED("用户未启用", "x000006"),
    USER_NOT_EXIST_OR_PASSWORD_ERROR("用户不存在或密码错误", "x000007"),

    AUTH_TOKEN_EXPIRED("token过期", "x100001"),
    AUTH_TOKEN_INVALID("token无效", "x100002"),
    AUTH_TOKEN_NOT_EXIST("token不存在", "x100003"),


    SYSTEM_EXCEPTION("系统异常", "x999999");


    private final String name;
    private final String code;

    ErrorCode(String name, String code) {
        this.name = name;
        this.code = code;
    }


}
