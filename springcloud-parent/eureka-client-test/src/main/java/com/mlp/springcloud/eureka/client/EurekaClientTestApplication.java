package com.mlp.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class EurekaClientTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientTestApplication.class, args);
    }

}
