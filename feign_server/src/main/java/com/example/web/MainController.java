package com.example.web;

import com.example.serverClient.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ChuChen on 2017/4/10.
 */
@RestController
public class MainController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/add")
    public Integer add() {
        return discoveryClient.add(10, 20);
    }
}
