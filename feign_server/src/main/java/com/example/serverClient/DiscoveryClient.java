package com.example.serverClient;

import com.example.serverClient.impl.DiscoveryClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ChuChen on 2017/4/10.
 */
@FeignClient(value = "discovery-service", fallback = DiscoveryClientImpl.class)
public interface DiscoveryClient {

    @RequestMapping("/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
