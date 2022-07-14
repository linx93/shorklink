package com.linx.shorklink.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 本系统配置
 *
 * @author linx
 * @since 2022/7/14 下午11:27
 */
@Data
@Component
@ConfigurationProperties(prefix = "system")
public class SystemConfig {
    /**
     * 比如：http://www.baidu.com
     */
    private String domain;

    /**
     * hhtp、https
     */
    private String protocol;
}
