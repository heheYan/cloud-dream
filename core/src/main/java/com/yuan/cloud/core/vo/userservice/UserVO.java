package com.yuan.cloud.core.vo.userservice;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yuan.cloud.core.serializer.EmailSerializer;
import com.yuan.cloud.core.serializer.IdCardSerializer;
import com.yuan.cloud.core.serializer.MobileSerializer;
import com.yuan.cloud.core.serializer.RealNameSerializer;
import com.yuan.cloud.core.vo.AbstractBasicVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * VO for {@link com.yuan.cloud.userservice.entity.User}
 */
@Getter
@Setter
public class UserVO extends AbstractBasicVO {

    /*用户名*/
    private String username;
    /*昵称*/
    private String nickName;
    /*头像*/
    private String avatar;
    /**
     * 真实姓名脱敏
     */
    @JsonSerialize(using = RealNameSerializer.class)
    private String realName;

    /**
     * 身份证号脱敏
     */
    @JsonSerialize(using = IdCardSerializer.class)
    private String identityNumber;

    /**
     * 邮箱脱敏
     */
    @JsonSerialize(using = EmailSerializer.class)
    private String email;

    /**
     * 手机号脱敏
     */
    @JsonSerialize(using = MobileSerializer.class)
    private String mobile;
    /*年龄*/
    private Integer age;
    /*性别*/
    private String gender;

    private Boolean locked;

    private Boolean disabled;

    private List<RoleVO> roles;

//    private List<PermissionVO> permissions;
}
