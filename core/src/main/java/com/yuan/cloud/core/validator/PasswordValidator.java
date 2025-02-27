package com.yuan.cloud.core.validator;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.yuan.cloud.core.annotation.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Mr.Y
 * Created on 2024-10-21 16:28
 * @description 密码参数校验
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public void initialize(Password constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String pwd, ConstraintValidatorContext constraintValidatorContext) {
        // 密码为空，则不校验
        return StrUtil.isBlankIfStr(pwd) || ReUtil.isMatch("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,16}$", pwd.trim());
    }
}
