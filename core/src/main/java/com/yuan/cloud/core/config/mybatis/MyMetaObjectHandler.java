package com.yuan.cloud.core.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Mr.Y
 * Created on 2024-11-29 23:04
 * @description mybatis-plus字段默认填充配置
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        fillStrategy(metaObject, "gmtCreate", LocalDateTime.now());
        fillStrategy(metaObject, "gmtModified", LocalDateTime.now());
        fillStrategy(metaObject, "deleted", false);
        fillStrategy(metaObject, "disabled", false);
        fillStrategy(metaObject, "locked", false);
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        fillStrategy(metaObject, "gmtModified", LocalDateTime.now());
    }
}
