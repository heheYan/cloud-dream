package com.yuan.cloud.core.exception.handler;

import com.alibaba.fastjson2.JSONObject;
import com.yuan.cloud.core.exception.YuanApiException;
import com.yuan.cloud.core.response.YuanR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import java.util.Objects;

import static com.yuan.cloud.core.enums.YuanStatusEnum.*;

/**
 * @author YuAN
 * Created on 2025-03-10 09:54
 * @description 全局异常捕获处理类
 */
@Slf4j
@RestControllerAdvice
public class YuanWebExceptionHandler {
    /**
     * 自定义异常捕获
     *
     * @param e 自定义异常
     * @return YuanR
     */
    @ExceptionHandler(YuanApiException.class)
    public YuanR<String> handleYuanApiException(YuanApiException e) {
        log.error("捕获到自定义异常：{}", e.getMessage());
        return YuanR.fail(e.getErrEnum(), e.getMessage());
    }

    /**
     * 参数校验异常捕获
     *
     * @param e 异常
     * @return YuanR
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public YuanR<JSONObject> handleArgsNotValidException(MethodArgumentNotValidException e) {
        JSONObject errData = new JSONObject();
        if (!e.getBindingResult().getFieldErrors().isEmpty()) {
            for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
                errData.put(fieldError.getField(), Objects.requireNonNull(fieldError.getDefaultMessage()));
            }
        }
        log.error("参数校验异常：{}", errData);
        return YuanR.fail(VALID_ERROR, errData);
    }

    /**
     * token过期异常捕获
     *
     * @param e 异常
     * @return YuanR
     */
    /*@ExceptionHandler(TokenExpiredException.class)
    public YuanR<String> handleTokenExpiredException(TokenExpiredException e) {
        log.error("token已过期：{}", e.getMessage());
        return YuanR.fail(TOKEN_EXPIRED, e.getMessage());
    }*/

    /**
     * 权限不足异常捕获
     *
     * @param e 异常
     * @return YuanR
     */
    @ExceptionHandler(AuthenticationException.class)
    public YuanR<String> handleException(AuthenticationException e) {
        log.error("权限不足：{}", e.getMessage());
        return YuanR.fail(FORBIDDEN, e.getMessage());
    }

    /**
     * 全局异常兜底捕获
     *
     * @param e 异常
     * @return YuanR
     */
    @ExceptionHandler(Exception.class)
    public YuanR<JSONObject> baseHandleException(Exception e) {
        log.error("捕获到全局异常：{}, {}", e.getMessage(), e.getLocalizedMessage());
        return YuanR.fail(INTERNAL_SERVER_ERROR);
    }
}
