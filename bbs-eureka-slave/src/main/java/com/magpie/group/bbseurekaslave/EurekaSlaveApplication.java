package com.magpie.group.bbseurekaslave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @Description: 服务注册中心
 * @date: 2019/4/17 11:59
 * @author：zhaoxuezhao
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSlaveApplication.class, args);
    }

}
