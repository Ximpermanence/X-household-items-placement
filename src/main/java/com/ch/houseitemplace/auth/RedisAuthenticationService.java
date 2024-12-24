package com.ch.houseitemplace.auth;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisAuthenticationService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisAuthenticationService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


/*

    */
/**
     * from Redis
     *//*

    public Authentication getAuthenticationFromRedis(String authorizationKey) {
        Object authenticationObj = redisTemplate.opsForValue().get(authorizationKey);
        if (authenticationObj != null) {
            // 这里需要确保能够将对象反序列化为 Authentication 对象
            return (Authentication) authenticationObj;
        }
        return null;
    }

    */
/**
     * 变成key
     *//*

    public String extractAuthorizationKey(Authentication authentication) {
        LoginUserDetail principal = (LoginUserDetail) authentication.getPrincipal();
        String id = principal.getId();
        String username = principal.getUsername();
        String key = SecureUtil.sha1(username) + id;
        // 提取 Token 或者 Session ID 作为 Redis 中的 Key,此处为什么不用UUID？，反正是作为token,不需要重复
        return key;
    }


    */
/**
     * 存入redis
     *//*

    public String saveAuthenticationToRedis(Authentication authentication) {

        String key = extractAuthorizationKey(authentication);
        // 假设 RedisTemplate 配置为使用 JSON 序列化
        redisTemplate.opsForValue().set(key, authentication, 1, TimeUnit.HOURS);
        return key;
    }
*/



    private static final String TOKEN_PREFIX = "auth_token:";

    // 存入Redis
    public void storeToken(String token, String userInfo) {
        redisTemplate.opsForValue().set(TOKEN_PREFIX + token, userInfo);
    }

    // 从Redis获取用户信息
    public String getUserInfo(String token) {
        return (String) redisTemplate.opsForValue().get(TOKEN_PREFIX + token);
    }

    // 删除token
    public void deleteToken(String token) {
        redisTemplate.delete(TOKEN_PREFIX + token);
    }

}
