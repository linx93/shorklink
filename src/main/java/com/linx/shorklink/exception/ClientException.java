package com.linx.shorklink.exception;

import com.linx.shorklink.constant.ResultCode;

/**
 * 客户端异常
 *
 * @author linx
 * @since 2022/7/11 下午11:18
 */
public class ClientException extends BasicException {
    public ClientException(String code, String message) {
        super(code, message);
    }

    public ClientException() {
        super(ResultCode.CLIENT_ERROR);
    }

    public ClientException(ResultCode resultCode) {
        super(resultCode);
    }

    public ClientException(String message) {
        super(message);
    }
}
