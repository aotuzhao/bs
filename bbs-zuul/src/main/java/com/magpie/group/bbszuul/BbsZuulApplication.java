package com.magpie.group.bbszuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class BbsZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsZuulApplication.class, args);
    }

}
