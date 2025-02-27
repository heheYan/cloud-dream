package com.yuan.cloud.core.validator;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import com.yuan.cloud.core.annotation.Idcard;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author Mr.Y
 * Created on 2024-10-21 16:28
 * @description 身份证号参数校验
 */
public class IdcardValidator implements ConstraintValidator<Idcard, String> {
    @Override
    public void initialize(Idcard constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String idCard, ConstraintValidatorContext constraintValidatorContext) {
        /* 校验参数是否为身份证号 */
        return StrUtil.isBlankIfStr(idCard) || IdcardUtil.isValidCard(idCard);
    }
}
