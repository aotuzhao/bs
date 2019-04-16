package com.magpie.bbs.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class);
    }
}
