package com.linx.shorklink.utils;

import com.linx.shorklink.constant.Protocol;
import com.linx.shorklink.constant.ResultCode;
import com.linx.shorklink.exception.ClientException;
import org.apache.commons.validator.routines.UrlValidator;

/**
 * 验证工具
 *
 * @author linx
 * @since 2022/7/11 下午11:35
 */
public class ValidatorUtil {
    private ValidatorUtil() {
    }

    private final static UrlValidator urlValidator = new UrlValidator(new String[]{Protocol.https.name(), Protocol.http.name()});

    public static boolean isUrl(String url) {
        if (!urlValidator.isValid(url)) {
            throw new ClientException(ResultCode.URL_ERROR);
        }
        return true;
    }
}
