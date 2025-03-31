package com.yuan.cloud.userservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author YuAN
 * Created on 2025-03-25 22:51
 * @description Spring Security 白名单资源配置类
 */
@Getter
@Setter
@Component
@ConditionalOnProperty(prefix = "yuan.security.ignored", havingValue = "true")
@ConfigurationProperties(prefix = "yuan.security.ignored")
public class IgnoreUrlsConfig {

    private String[] urls;
}