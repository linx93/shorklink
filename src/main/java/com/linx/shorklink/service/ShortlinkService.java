package com.linx.shorklink.service;

import com.linx.shorklink.model.po.UrlMap;
import com.linx.shorklink.model.request.CreateShortlinkRequest;


/**
 * 短链接处理
 *
 * @author linx
 * @since 2022/7/11 下午10:20
 */
public interface ShortlinkService {
    /**
     * CreateShortlinkRequest
     *
     * @param element element
     * @return Mono<UrlMap>
     */
    UrlMap defaultCreate(CreateShortlinkRequest element);
}
