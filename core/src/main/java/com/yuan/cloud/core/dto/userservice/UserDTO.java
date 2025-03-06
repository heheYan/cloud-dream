package com.yuan.cloud.core.dto.userservice;

import com.yuan.cloud.core.annotation.Idcard;
import com.yuan.cloud.core.annotation.Mobile;
import com.yuan.cloud.core.annotation.Password;
import com.yuan.cloud.core.dto.AbstractBasicDTO;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * DTO for {@link com.yuan.cloud.userservice.entity.User}
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends AbstractBasicDTO {
    String username;
    @Password
    String password;
    String nickName;
    String avatar;
    String realName;
    @Idcard
    String identityNumber;
    @Email
    String email;
    @Mobile
    String mobile;
    Integer age;
    String gender;
    Integer locked;
    Integer disabled;
    /* 用户角色列表 */
    List<Long> roleIds;
}