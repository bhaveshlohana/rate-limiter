package com.bhavesh.learn.rate_limiter.core;

import com.bhavesh.learn.rate_limiter.model.RateLimitConfig;
import com.bhavesh.learn.rate_limiter.model.RateLimitResponse;

public interface RateLimiter {
    RateLimitResponse isAllowed(String userId, RateLimitConfig rateLimitConfig);

    RateLimitResponse isAllowedLua(String userId, RateLimitConfig rateLimitConfig);
}
