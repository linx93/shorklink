package com.linx.shorklink.model.request;


import java.io.Serializable;

/**
 * 创建短链接
 *
 * @author linx
 * @since 2022/7/11 下午9:38
 */
public record CreateShortlinkRequest(String requestId, String longUrl, String description) implements Serializable {
}
