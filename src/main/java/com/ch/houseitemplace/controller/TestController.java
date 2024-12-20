package com.ch.houseitemplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("redis-set")
    public String testGetSetRedisTemplate() {
        redisTemplate.opsForValue().set("key", "value");
        return redisTemplate.opsForValue().get("key");
    }

    @GetMapping("mybatis-plus")
    public String testMybatisPlus() {
        return "Hello MybatisPlus";

    }
}
