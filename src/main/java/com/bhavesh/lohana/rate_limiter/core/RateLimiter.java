package com.bhavesh.lohana.rate_limiter.core;

import com.bhavesh.lohana.rate_limiter.domain.Algorithm;
import com.bhavesh.lohana.rate_limiter.model.RateLimitConfig;
import com.bhavesh.lohana.rate_limiter.model.RateLimitResponse;
import com.bhavesh.lohana.rate_limiter.model.RateLimitStatus;

public interface RateLimiter {
    RateLimitResponse isAllowed(String userId, RateLimitConfig rateLimitConfig);

    RateLimitResponse isAllowedLua(String userId, RateLimitConfig rateLimitConfig);
}
