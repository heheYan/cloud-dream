package com.yuan.cloud.core.util.query;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.cloud.core.annotation.YuanQueryType;
import com.yuan.cloud.core.enums.QueryTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author Mr.Y
 * Created on 2024-12-17 17:27
 * @description 查询条件拼接工具类
 */
@Slf4j
public class QueryBuilderUtil {

    public static <Q, T> QueryWrapper<T> build(Q query) throws IllegalAccessException {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (query == null) {
            return wrapper;
        }

        Field[] fields = query.getClass().getDeclaredFields();
        for (Field field : fields) {
            ReflectionUtils.makeAccessible(field);
            YuanQueryType queryTypeAnnotation = field.getAnnotation(YuanQueryType.class);
            if (queryTypeAnnotation != null) {
                QueryTypeEnum type = queryTypeAnnotation.type();
                Object fieldValue = field.get(query);
                if (fieldValue != null) {
                    switch (type) {
                        case EQUAL -> {
                            if (!fieldValue.toString().isEmpty()) {
                                wrapper.eq(field.getName(), fieldValue.toString());
                            }
                        }
                        case LIKE -> {
                            if (!fieldValue.toString().isEmpty()) {
                                wrapper.like(field.getName(), fieldValue.toString());
                            }
                        }
                        case IN -> {
                            if (fieldValue instanceof Object[]) {
                                wrapper.in(field.getName(), (Object[]) fieldValue);
                            } else {
                                log.warn("Field {} annotated with IN but value is not an array", field.getName());
                            }
                        }
                        case GREATER_THAN -> wrapper.gt(field.getName(), fieldValue);
                        case LESS_THAN -> wrapper.lt(field.getName(), fieldValue);
                        case BETWEEN -> {
                            // 默认日期格式的between
                            if (fieldValue instanceof Date[] fieldValues && fieldValues.length == 2) {

                                wrapper.between(field.getName(), DateUtil.beginOfDay(fieldValues[0]), DateUtil.endOfDay(fieldValues[1]));
                            } else {
                                log.warn("Field {} annotated with BETWEEN but value is not a valid array of two elements", field.getName());
                            }
                        }
                        default -> {
                            log.warn("Unhandled query type {} for field {}", type, field.getName());
                            wrapper.eq(field.getName(), fieldValue);
                        }
                    }
                }
            }
        }
        return wrapper;
    }
}
