package com.yuan.cloud.core.enums;

import lombok.Getter;

/**
 * @author Mr.Y
 * Created on 2024-11-28 14:21
 * @description 返回状态枚举类
 */
@Getter
public enum YuanStatusEnum {
    SUCCESS(200, "操作成功"),
    FAIL(400, "操作失败"),
    VALID_ERROR(40001, "参数校验失败"),
    TOKEN_EXPIRED(40002, "token过期"),
    TOKEN_INVALID(40003, "token无效"),
    USER_NOT_FOUND(40004, "用户不存在"),
    PASSWORD_ERROR(40005, "密码错误"),
    FILE_UPLOAD_FAIL(40007, "文件上传失败"),
    FILE_REMOVE_FAIL(40008, "文件删除失败"),
    QUERY_CONDITION_ERROR(40009, "查询条件拼接失败"),
    VERIFICATION_CODE_ERROR(40010, "验证码无效"),
    DATA_NOT_EXIST(40011, "未查询到相关数据"),
    USER_EXIST_ERROR(40011, "用户名已存在"),

    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "无权限访问"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "不允许的方法"),

    REQUEST_TIMEOUT(408, "请求超时"),

    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用");

    private final int code;
    private final String msg;

    YuanStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
