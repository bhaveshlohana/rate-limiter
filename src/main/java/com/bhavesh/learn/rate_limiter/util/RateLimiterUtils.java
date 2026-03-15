package com.bhavesh.learn.rate_limiter.util;

import com.bhavesh.learn.rate_limiter.domain.Algorithm;

import static com.bhavesh.learn.rate_limiter.constants.ApplicationConstants.*;

public class RateLimiterUtils {
    public static String getKey(String userId, Algorithm algorithm) {
        return RATELIMIT + algorithm.toString() + SEPARATOR + userId;
    }

    public static String getKey(String userId, Algorithm algorithm, Long windowStart) {
        return RATELIMIT + algorithm.toString() + SEPARATOR + userId + SEPARATOR + windowStart;
    }

    public static String getConfigKey(String clientType) {
        return RATELIMIT_CONFIG_PREFIX + clientType;
    }


    public static String getConfigKeyPattern() {
        return getConfigKey("*");
    }
}
