package com.linx.shorklink.constant;

/**
 * 响应业务code
 *
 * @author linx
 * @since 2022/7/11 下午11:09
 */
public enum ResultCode {
    /**
     * 成功
     */
    OK(20000, "successful"),
    FAILED(50000, "Internal Server Error"),

    /**
     * [40000,50000)：客户端异常
     */
    CLIENT_ERROR(40000, "client error"),
    /**
     * 非法的url
     */
    URL_ERROR(40001, "illegal url"),

    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(int code, String message) {
    }
}
