package com.bhavesh.lohana.rate_limiter.util;

import com.bhavesh.lohana.rate_limiter.domain.Algorithm;
import org.junit.jupiter.api.Test;

import static com.bhavesh.lohana.rate_limiter.constants.ApplicationConstants.RATELIMIT;
import static com.bhavesh.lohana.rate_limiter.constants.ApplicationConstants.SEPARATOR;
import static com.bhavesh.lohana.rate_limiter.constants.ApplicationConstants.RATELIMIT_CONFIG_PREFIX;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RateLimiterUtilsTest {

    @Test
    void getKey_buildsCorrectKey() {
        String key = RateLimiterUtils.getKey("u1", Algorithm.FIXED_WINDOW);
        assertEquals(RATELIMIT + Algorithm.FIXED_WINDOW + SEPARATOR + "u1", key);
    }

    @Test
    void getConfigKey_buildsConfigKey() {
        assertEquals(RATELIMIT_CONFIG_PREFIX + "T1", RateLimiterUtils.getConfigKey("T1"));
    }

    @Test
    void getKey_withAlgorithmAndUser_returnsExpected() {
        String key = RateLimiterUtils.getKey("user1", Algorithm.FIXED_WINDOW);
        assertEquals(RATELIMIT + Algorithm.FIXED_WINDOW + SEPARATOR + "user1", key);
    }

    @Test
    void getConfigKeyPattern_returnsPattern() {
        assertEquals(RATELIMIT_CONFIG_PREFIX + "*", RateLimiterUtils.getConfigKeyPattern());
    }
}