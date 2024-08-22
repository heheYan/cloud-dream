package com.hedit.acecenter.response;

import cn.hutool.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Mr.Y
 * Created on 2024-08-19 16:57
 * @description 通用接口返回
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AHeResult {
    private int code;
    private String msg;
    private Object data;

    public AHeResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    };


    public static AHeResult success(String msg) {
        return success(msg, null);
    }

    public static AHeResult success(String msg, Object data) {
        return new AHeResult(HttpStatus.HTTP_OK, msg, data);
    }


    public static AHeResult fail(String msg) {
        return fail(msg, null);
    }

    public static AHeResult fail(String msg, Object data) {
        return new AHeResult(HttpStatus.HTTP_IM_USED, msg, data);
    }
}
