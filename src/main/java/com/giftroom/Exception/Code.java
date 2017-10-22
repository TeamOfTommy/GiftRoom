package com.giftroom.Exception;

/**
 * Created by tommy on 2017/10/22.
 */
public enum  Code {

    SeverErrorCode(1001, "内部错误"),
    SmsCodeError(2001, "验证码错误"),
    IsUserExistError(3001, "该手机号已注册");

    private Integer code;
    private String message;

    Code(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
