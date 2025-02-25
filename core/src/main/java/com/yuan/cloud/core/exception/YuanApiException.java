package com.yuan.cloud.core.exception;

import com.yuan.cloud.core.enums.YuanStatusEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mr.Y
 * Created on 2024-11-28 20:28
 * @description 项目通用接口异常
 */
@Getter
@Setter
public class YuanApiException extends RuntimeException {
    private YuanStatusEnum errEnum;

    public YuanApiException(String message) {
        super(message);
        errEnum = YuanStatusEnum.FAIL;
    }

    public YuanApiException(YuanStatusEnum errEnum) {
        super(errEnum.getMsg());
        this.errEnum = errEnum;
    }
}
