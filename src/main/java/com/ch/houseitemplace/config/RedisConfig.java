package com.ch.houseitemplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // 设置键和值的序列化方式
        template.setKeySerializer(new StringRedisSerializer()); // key 序列化
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // value 序列化
        template.setHashKeySerializer(new StringRedisSerializer()); // hash key 序列化
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer()); // hash value 序列化

        return template;
    }
}
