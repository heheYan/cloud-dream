package com.yuan.cloud.userservice.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author YuAN
 * Created on 2025-03-25 22:48
 * @description
 */
@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
    @Resource
    IgnoreUrlsConfig ignoreUrlsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 关闭csrf配置
                .csrf(AbstractHttpConfigurer::disable)
                // 新版配置请求过滤拦截
                .authorizeHttpRequests((authorizeHttpRequests) -> {
                    authorizeHttpRequests
                            // 放行配置的白名单资源
                            .requestMatchers(ignoreUrlsConfig.getUrls()).permitAll()
                            // 其他所有请求都需要认证
                            .anyRequest().authenticated();
                })
                // 禁用session
                .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 配置跨域
                .cors(AbstractHttpConfigurer::disable);
        // 配置jwt
//                .oauth2ResourceServer(resourceServerConfig -> resourceServerConfig.jwt(
//                        jwtConfigurer -> jwtDecoder()
//                ));
        return http.build();
    }

}
