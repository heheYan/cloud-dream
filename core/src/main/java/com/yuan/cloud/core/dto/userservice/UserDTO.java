package com.yuan.cloud.core.dto.userservice;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.User}
 */
@Value
public class UserDTO implements Serializable {
    String username;
    String password;
    String nickName;
    String avatar;
    String realName;
    String identityNumber;
    String email;
    String mobile;
    Integer age;
    String gender;
    Integer locked;
    Integer disabled;
    Long id;
    LocalDateTime gmtCreate;
    LocalDateTime gmtModified;
    Boolean deleted;
}