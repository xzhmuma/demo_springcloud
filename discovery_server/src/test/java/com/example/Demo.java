package com.example;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ChuChen on 2017/4/21.
 */
public class Demo {
    public static void main(String[] args){
        StringRedisTemplate stringRedisTemplate=new StringRedisTemplate();

        Map<String,String> map =new HashMap<>();
        HashOperations hashOperations= stringRedisTemplate.opsForHash();

        hashOperations.put("person","a","aaaaa");
        hashOperations.put("person","b","bbbbbb");
        Boolean b=hashOperations.hasKey("person","a");

        System.out.println(b);
    }
}
