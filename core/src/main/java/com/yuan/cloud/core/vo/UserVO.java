package com.yuan.cloud.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.yuan.cloud.core.serializer.EmailSerializer;
import com.yuan.cloud.core.serializer.IdCardSerializer;
import com.yuan.cloud.core.serializer.MobileSerializer;
import com.yuan.cloud.core.serializer.RealNameSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * VO for {@link com.yuan.cloud.userservice.entity.User}
 */
@Getter
@Setter
public class UserVO {

    /**
     * 主键转String
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
}
