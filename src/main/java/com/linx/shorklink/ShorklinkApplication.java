package com.linx.shorklink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author linx
 */
@SpringBootApplication
@EnableTransactionManagement
public class ShorklinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShorklinkApplication.class, args);
    }

}
