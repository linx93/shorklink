package com.linx.shorklink.repository;

import com.linx.shorklink.model.po.UrlMap;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author linx
 * @since 2022/7/10 下午11:05
 */
@Repository
public interface UrlMapRepository extends ReactiveCrudRepository<UrlMap, String>, ReactiveQueryByExampleExecutor<UrlMap> {
    /**
     * findByShortUrl
     *
     * @param shortUrl 短链接
     * @return
     */
    @Query("select id, short_url, long_url, short_url_digest, long_url_digest, compression_code, description, url_status, create_time, edit_time, creator, editor, deleted, version from url_map u where u.short_url =:shortUrl")
    Flux<UrlMap> findByShortUrl(String shortUrl);
}
