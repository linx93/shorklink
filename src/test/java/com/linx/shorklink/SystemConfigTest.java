package com.linx.shorklink;

import com.linx.shorklink.config.SystemConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 配置测试
 *
 * @author linx
 * @since 2022/7/15 上午12:26
 */
@SpringBootTest
public class SystemConfigTest {
    @Autowired
    SystemConfig systemConfig;

    @Test
    void readSystemConfig() {
        System.out.println(systemConfig);
    }
}
