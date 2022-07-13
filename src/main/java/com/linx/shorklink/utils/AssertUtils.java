package com.linx.shorklink.utils;


import com.linx.shorklink.exception.BasicException;

/**
 * 断言工具
 *
 * @author linx
 * @since 2022/7/11 下午11:05
 */
public class AssertUtils{
    /**
     * isTrue
     * @param expression bool
     * @param message msg
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BasicException(message);
        }
    }
}
