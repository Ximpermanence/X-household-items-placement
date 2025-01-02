package com.ch.houseitemplace.auth;

import cn.hutool.json.JSONUtil;
import com.ch.houseitemplace.pojo.LoginUserDetail;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisAuthenticationService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisAuthenticationService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static final String TOKEN_PREFIX = "auth_token:";

    // 存入Redis
    public void storeToken(String token, String userInfo) {
        redisTemplate.opsForValue().set(TOKEN_PREFIX + token, userInfo);
    }

    // 从Redis获取用户信息
    public LoginUserDetail getUserInfo(String token) {
        Object o = redisTemplate.opsForValue().get(TOKEN_PREFIX + token);

        return Optional.ofNullable(o).map(t -> JSONUtil.toBean((String) t, LoginUserDetail.class)).orElse(null);
    }

    // 删除token
    public void deleteToken(String token) {
        redisTemplate.delete(TOKEN_PREFIX + token);
    }

}
