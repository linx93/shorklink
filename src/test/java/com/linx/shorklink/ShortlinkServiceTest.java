package com.linx.shorklink;

import com.linx.shorklink.model.request.CreateShortlinkRequest;
import com.linx.shorklink.service.ShortlinkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author linx
 * @since 2022/7/15 上午12:53
 */
@SpringBootTest
public class ShortlinkServiceTest {


    @Autowired
    private ShortlinkService shortlinkService;

    @Test
    void create() {
        shortlinkService.defaultCreate(new CreateShortlinkRequest("1", "https://www.baidu.com/", "i am linx"));
    }

}
