package com.yuan.cloud.core.vo.userservice;

import lombok.Data;

/**
 * 登录结果返回对象
 */
@Data
public class LoginResultVO {
    String accessToken;
    String refreshToken;
    String expiresIn;

    boolean success;
    String message;
    String code;

    /**
     * 登录成功
     *
     * @param accessToken  token信息
     * @param refreshToken 刷新token
     * @param expiresIn    过期时间
     * @return 登录成功对象
     */
    public static LoginResultVO success(String accessToken, String refreshToken, String expiresIn) {
        LoginResultVO resultVO = new LoginResultVO();
        resultVO.setSuccess(true);
        resultVO.setAccessToken(accessToken);
        resultVO.setRefreshToken(refreshToken);
        resultVO.setExpiresIn(expiresIn);
        return resultVO;
    }

    /**
     * 登录失败
     *
     * @param message 失败信息
     * @param code    错误码
     * @return 失败对象
     */
    public static LoginResultVO fail(String message, String code) {
        LoginResultVO resultVO = new LoginResultVO();
        resultVO.setSuccess(false);
        resultVO.setMessage(message);
        resultVO.setCode(code);
        return resultVO;
    }
}
