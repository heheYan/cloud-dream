package com.yuan.cloud.core.annotation;

import com.yuan.cloud.core.validator.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mr.Y
 * Created on 2024-10-21 17:05
 * @description 密码格式校验
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "密码必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-16 之间";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
