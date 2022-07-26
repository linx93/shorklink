package com.linx.shorklink;

import com.linx.shorklink.model.po.UrlMap;
import com.linx.shorklink.model.request.CreateShortlinkRequest;
import com.linx.shorklink.repository.UrlMapRepository;
import com.linx.shorklink.service.ShortlinkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * @author linx
 * @since 2022/7/15 上午12:53
 */
@SpringBootTest
public class ShortlinkServiceTest {


    @Autowired
    private ShortlinkService shortlinkService;

    @Autowired
    private UrlMapRepository urlMapRepository;

    @Test
    void create() {
        shortlinkService.defaultCreate(new CreateShortlinkRequest("1", "https://www.baidu.com/", "i am linx"));
    }


    @Test
    void select() {
//        Flux<UrlMap> byShortUrl = urlMapRepository.findByShortUrl("11");
//        byShortUrl.map(item -> {
//            System.out.println("item=" + item);
//            return item;
//        });
        urlMapRepository.findAll()
                .publishOn(Schedulers.boundedElastic())
                .map(element -> {
                    //打印出现的线程是boundedElastic-1，很明显这个时候就不存在耗尽netty服务器的Worker Group中的所以线程的情况
                    System.out.println(Thread.currentThread().getName() + " ------- " + element);
                    return element;
                }).as(StepVerifier::create) //
                .expectNextCount(5) //
                .verifyComplete();
    }

}
