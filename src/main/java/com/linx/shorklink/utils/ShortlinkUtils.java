package com.linx.shorklink.utils;


import cn.hutool.core.util.HashUtil;

/**
 * 处理长连接、短链接
 *
 * @author linx
 * @since 2022/7/11 下午10:31
 */
public class ShortlinkUtils {
    private final static char[] CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private static final int SIZE = CHARS.length;


    /**
     * 得到压缩后的短码
     *
     * @param longUrl 完整的长连接
     * @return 短码
     */
    public static String toCompression(String longUrl) {
        AssertUtils.isTrue(longUrl != null && !"".equals(longUrl.trim()), "longUrl不能为空");
        return toBase62Str(HashUtil.tianlHash(longUrl));
    }

    /**
     * 得到完整短链接
     *
     * @param longUrl 完整的长连接
     * @return 完整短链接
     */
    public static String toCompression(String address, String longUrl) {
        AssertUtils.isTrue(longUrl != null && "".equals(longUrl.trim()), "longUrl不能为空");
        return address + "/" + toBase62Str(HashUtil.tianlHash(longUrl));
    }

    private static String toBase62Str(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int i = (int) (num % SIZE);
            sb.append(CHARS[i]);
            num /= SIZE;
        }
        return sb.reverse().toString();
    }

}
