package com.fh.shop.common;

public enum ResponseEnum {
    ERROR(-1, "error"),
    USERNAME_USERPWD_IS_EMPTY(1000, "用户名或密码为空"),
    USERNAME_IS_EXIST(1003, "用户名已存在"),
    USERNAME_IS_ERROR(1001, "用户名错误"),
    USERPWD_IS_ERROR(1002, "密码错误"),
    HEADER_IS_MISS(2000, "头信息不完整"),
    SIGN_IS_ERROR(2001, "验签失败"),
    SMS_PHONE_IS_EMPTY(3000, "手机号不能为空"),
    SMS_PHONE_LENGTH_ERROR(3001, "手机号不合法"),
    SMS_ERROR(3002, "调用网易云信接口异常"),
    SMS_REPEAT_SEND(3003, "不允许重复发送"),
    SMS_CODE_TIME_OUT(3004, "验证码超时，请再次发送"),
    SMS_CODE_IS_ERROR(3005, "验证码错误"),

    TIMEOUT(2002, "超时"),
    SUCCESS(200, "ok");

    private int code;

    private String msg;

    private ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
