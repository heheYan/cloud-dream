package com.yuan.cloud.core.validator;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.core.util.StrUtil;
import com.yuan.cloud.core.annotation.Mobile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Mr.Y
 * Created on 2024-10-21 16:28
 * @description 手机号参数校验
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {
    @Override
    public void initialize(Mobile constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext constraintValidatorContext) {
        /* 校验参数是否为手机号,如果不传值不做校验 */
        return StrUtil.isBlankIfStr(mobile) || PhoneUtil.isMobile(mobile);
    }
}
