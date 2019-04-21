package com.magpie.group.bbshystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class BbsHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbsHystrixDashboardApplication.class, args);
    }

}
