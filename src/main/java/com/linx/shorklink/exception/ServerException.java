package com.linx.shorklink.exception;

import com.linx.shorklink.constant.ResultCode;

/**
 * 服务端异常
 *
 * @author linx
 * @since 2022/7/11 下午11:23
 */
public class ServerException extends BasicException {
    public ServerException(String code, String message) {
        super(code, message);
    }

    public ServerException(ResultCode resultCode) {
        super(resultCode);
    }

    public ServerException() {
        super(ResultCode.FAILED);
    }

    public ServerException(String message) {
        super(message);
    }
}
