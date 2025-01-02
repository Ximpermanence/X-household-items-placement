package com.ch.houseitemplace.controller;

import com.ch.houseitemplace.pojo.entity.UserInfo;
import com.ch.houseitemplace.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("redis-set")
    public String testGetSetRedisTemplate() {
        redisTemplate.opsForValue().set("key", "value");
        return redisTemplate.opsForValue().get("key");
    }

    @GetMapping("mybatis-plus")
    public String testMybatisPlus() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword("admin");
        userInfoService.save(userInfo);

        List<UserInfo> list = userInfoService.list();

        return list.toString();

    }
}
