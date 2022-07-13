package com.linx.shorklink.handler;

import com.linx.shorklink.model.request.CreateShortlinkRequest;
import com.linx.shorklink.service.ShortlinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;

/**
 * 1
 *
 * @author linx
 * @since 2022/7/10 下午10:32
 */
@Component
public class ShortlinkHandler {
    private final ShortlinkService shortlinkService;

    public ShortlinkHandler(ShortlinkService shortlinkService) {
        this.shortlinkService = shortlinkService;
    }

    /**
     * 创将短连接
     *
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        //todo 这路还的研究以下CreateShortlinkRequest的参数验证怎么做
        Mono<Boolean> map = serverRequest.bodyToMono(CreateShortlinkRequest.class).publishOn(Schedulers.parallel()).map(shortlinkService::create);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(map, Boolean.class);

    }

}
