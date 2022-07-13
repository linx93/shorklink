package com.linx.shorklink.exception;

import com.linx.shorklink.constant.ResultCode;

/**
 * 基本异常
 *
 * @author linx
 * @since 2022/7/10 下午10:42
 */
public class BasicException extends RuntimeException {
    private String code;
    private String message;



    public BasicException(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public BasicException(ResultCode resultCode) {
        this.code = resultCode.name();
        this.message = message;
    }


    public BasicException(String message) {
        super(message);
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }



}
