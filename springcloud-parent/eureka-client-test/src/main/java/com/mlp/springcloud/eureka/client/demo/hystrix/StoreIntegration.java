package com.mlp.springcloud.eureka.client.demo.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail
        return 0;
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return 1;
    }
}
