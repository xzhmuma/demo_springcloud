package com.example.serverClient.impl;

import com.example.serverClient.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ChuChen on 2017/4/13.
 */
@Component
public class DiscoveryClientImpl implements DiscoveryClient {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
