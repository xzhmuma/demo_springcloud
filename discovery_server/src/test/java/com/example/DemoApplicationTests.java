package com.example;

import com.example.entity.basic.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Test
	public void contextLoads() {
		Map<String,String> map =new HashMap<>();
		HashOperations hashOperations= stringRedisTemplate.opsForHash();

		hashOperations.put("person","a","aaaaa");
		hashOperations.put("person","b","bbbbbb");
		Boolean b=hashOperations.hasKey("person","a");

		System.out.println(b);
	}

}
