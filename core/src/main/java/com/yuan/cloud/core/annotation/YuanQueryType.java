package com.yuan.cloud.core.annotation;

import com.yuan.cloud.core.enums.QueryTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mr.Y
 * Created on 2024-12-17 17:23
 * @description 查询条件注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface YuanQueryType {
    // 查询类型
    QueryTypeEnum type();

}
