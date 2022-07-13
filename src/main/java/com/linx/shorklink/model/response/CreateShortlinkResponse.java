package com.linx.shorklink.model.response;

import java.io.Serializable;

/**
 * 创建短链接的响应
 *
 * @author linx
 * @since 2022/7/11 下午9:41
 */
public record CreateShortlinkResponse(String requestId, String shortUr) implements Serializable {
}
