package com.yuan.cloud.core.config.beanscan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Y
 * Created on 2024-12-05 11:10
 * @description 基础Bean扫描配置
 */
@Slf4j
@Configuration
//@EnableFeignClients(basePackages = "com.yuan.cloud.core.client")
@ComponentScan(value = "com.yuan.cloud.core")
public class BeanConfigScanConfig {

}
