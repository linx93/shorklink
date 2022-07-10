package com.linx.shorklink.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 1
 *
 * @author linx
 * @since 2022/7/10 下午10:32
 */
@Component
public class ShortlinkHandler {

    /**
     * 创将短连接
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return null;
    }

}
