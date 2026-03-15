package com.bhavesh.lohana.rate_limiter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisConnectionTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void shouldConnectToRedis() {
        redisTemplate.opsForValue().set("testKey", "testValue");
        String value = redisTemplate.opsForValue().get("testKey");
        assert "testValue".equals(value);
    }
}
