package com.magpie.group.bbsconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BbsConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsConfigApplication.class, args);
    }

}
