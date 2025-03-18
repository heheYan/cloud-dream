package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.annotation.Password;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户登录信息
 */
@Data
public class LoginDTO {
    @NotBlank
    String username;
    @NotBlank
    @Password
    String password;
    @NotBlank
    String captcha;
    @NotBlank
    String uuid;
}
