package com.linx.shorklink.service.impl;

import cn.hutool.core.codec.Base58;
import cn.hutool.core.lang.hash.MurmurHash;
import cn.hutool.core.util.HashUtil;
import com.linx.shorklink.model.request.CreateShortlinkRequest;
import com.linx.shorklink.repository.UrlMapRepository;
import com.linx.shorklink.service.ShortlinkService;
import com.linx.shorklink.utils.ShortlinkUtils;
import com.linx.shorklink.utils.ValidatorUtil;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * 短链接处理
 *
 * @author linx
 * @since 2022/7/11 下午10:21
 */
@Service
public class ShortlinkServiceImpl implements ShortlinkService {
    private final UrlMapRepository urlMapRepository;

    public ShortlinkServiceImpl(UrlMapRepository urlMapRepository) {
        this.urlMapRepository = urlMapRepository;
    }

    @Override
    public Boolean create(CreateShortlinkRequest element) {
        ValidatorUtil.isUrl(element.longUrl());
        int i = MurmurHash.hash32(element.longUrl());
        HashUtil.tianlHash(element.longUrl());
        //urlMapRepository
        return null;
    }


   /* public static void main(String[] args) {
        String longUrl = "http://linx.site/info";
        long l = HashUtil.tianlHash(longUrl);
        String s = String.valueOf(l);
        System.out.println(l);
        System.out.println(s);

        byte[] bytes1 = "熊林".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes1));
        byte[] encode1 = Base64.getEncoder().encode(bytes1);
        System.out.println(new String(encode1));
        System.out.println(new String(Base64.getDecoder().decode("54aK5p6X")));
    }*/
}
