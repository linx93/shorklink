package com.linx.shorklink;

import com.linx.shorklink.model.po.UrlMap;
import com.linx.shorklink.repository.UrlMapRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import reactor.test.StepVerifier;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 持久层测试
 *
 * @author linx
 * @since 2022/7/10 下午11:13
 */
@SpringBootTest()
public class RepositoryTest {
    @Autowired
    UrlMapRepository urlMapRepository;


    @Test
    void urlMapRepositoryFindTest() {
        UrlMap urlMap = new UrlMap(null, "11", "sss1", "11", "11", "1232", "www1", 1, null, null, "linx", "linx", 1, 123L);

        var example = Example.of(urlMap);

        urlMapRepository.count(example)
                .as(StepVerifier::create) //
                .expectNext(1L) //
                .verifyComplete();

/*        urlMapRepository.findByShortUrl("11").
        as(StepVerifier::create) //
                .expectNextCount(1) //
                .verifyComplete();*/

    }


    @Test
    void urlMapRepositoryInsertTest() {
        UrlMap urlMap1 = new UrlMap(null, "11", "sss1", "11", "11", "1232", "www1", 1, OffsetDateTime.now(), OffsetDateTime.now(), "linx", "linx", 1, 123L);
        UrlMap urlMap2 = new UrlMap(null, "22", "sss2", "22", "22", "2223", "www2", 1, OffsetDateTime.now(), OffsetDateTime.now(), "linx", "linx", 1, 123L);
        urlMapRepository.saveAll(List.of(urlMap1, urlMap2))
                .as(StepVerifier::create) //
                .expectNextCount(2) //
                .verifyComplete();
    }
}

