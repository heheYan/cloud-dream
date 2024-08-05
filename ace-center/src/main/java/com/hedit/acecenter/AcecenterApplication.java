package com.hedit.acecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开启服务注册发现注解：  @EnableDiscoveryClient
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AcecenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcecenterApplication.class, args);
    }

}
