package com.linx.shorklink.config;

import com.linx.shorklink.handler.ShortlinkHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 路由配置
 *
 * @author linx
 * @since 2022/7/10 下午10:34
 */
@Configuration
public class RouterConfig {
    /**
     * 配置路由
     * @param handler
     * @return
     */
    @Bean
    RouterFunction<ServerResponse> shortlinkRouter(ShortlinkHandler handler) {
        return RouterFunctions.route()
                .POST("/create", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::create)
                //.GET("/func2", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::getSingle)
                .build();
    }
}
