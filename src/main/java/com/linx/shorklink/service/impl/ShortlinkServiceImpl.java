package com.linx.shorklink.service.impl;

import cn.hutool.core.util.HashUtil;
import com.linx.shorklink.config.SystemConfig;
import com.linx.shorklink.model.po.UrlMap;
import com.linx.shorklink.model.request.CreateShortlinkRequest;
import com.linx.shorklink.repository.UrlMapRepository;
import com.linx.shorklink.service.ShortlinkService;
import com.linx.shorklink.utils.ShortlinkUtils;
import com.linx.shorklink.utils.ValidatorUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.CRC32;

/**
 * 短链接处理
 *
 * @author linx
 * @since 2022/7/11 下午10:21
 */
@Service
public class ShortlinkServiceImpl implements ShortlinkService {
    private final UrlMapRepository urlMapRepository;
    private final SystemConfig systemConfig;


    public ShortlinkServiceImpl(UrlMapRepository urlMapRepository, SystemConfig systemConfig) {
        this.urlMapRepository = urlMapRepository;
        this.systemConfig = systemConfig;
    }

    @Override
    public UrlMap defaultCreate(CreateShortlinkRequest request) {
        ValidatorUtil.isUrl(request.longUrl());
        String compressionCode = ShortlinkUtils.toCompression(request.longUrl());
        String shortlink = buildShortlink(compressionCode);
        UrlMap urlMap = new UrlMap(null, shortlink, request.longUrl(), DigestUtils.md5DigestAsHex(shortlink.getBytes(StandardCharsets.UTF_8)), DigestUtils.md5DigestAsHex(request.longUrl().getBytes(StandardCharsets.UTF_8)), compressionCode, request.description(), 1, OffsetDateTime.now(), OffsetDateTime.now(), "linxCreator", "linxCreator", 0, 1L);
       urlMapRepository.save(urlMap);
        return null;
    }

    private String buildShortlink(String compression) {
        return String.format("%s://%s/%s", systemConfig.getProtocol(), systemConfig.getDomain(), compression);
    }

  /*  public static void main(String[] args) {
        String longUrl = "http://linx.site/info";
        long l = HashUtil.tianlHash(longUrl);
        String s = String.valueOf(l);
        System.out.println(l);
        System.out.println(s);
        byte[] bytes = "熊林".getBytes(StandardCharsets.UTF_8);
        System.out.println("bytes=" + Arrays.toString(bytes));
        byte[] encode1 = Base64.getEncoder().encode(bytes);
        System.out.println(new String(encode1));
        System.out.println(new String(Base64.getDecoder().decode("54aK5p6X")));
        CRC32 crc32 = new CRC32();
        crc32.update(1);
        System.out.println(crc32.getValue());
        System.out.println(1111 * 31);
        System.out.println(1111 * (2 * 2 * 2 * 2 * 2 - 1));
        System.out.println(1111 * 2 * 2 * 2 * 2 * 2 - 1111);
        System.out.println((1111 << 5) - 1111);
        // System.out.println(x * 31); ==> System.out.println(x * (2 * 2 * 2 * 2 * 2 - 1));
    }*/



}
