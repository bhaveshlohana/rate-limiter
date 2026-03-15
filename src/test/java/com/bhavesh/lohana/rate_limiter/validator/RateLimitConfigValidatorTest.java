package com.bhavesh.lohana.rate_limiter.validator;

import com.bhavesh.lohana.rate_limiter.domain.Algorithm;
import com.bhavesh.lohana.rate_limiter.exception.InvalidConfigException;
import com.bhavesh.lohana.rate_limiter.model.RateLimitConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RateLimitConfigValidatorTest {

    private final RateLimitConfigValidator validator = new RateLimitConfigValidator();

    @Test
    void validFixedWindowConfig_passes() {
        RateLimitConfig cfg = RateLimitConfig.builder()
                .algorithm(Algorithm.FIXED_WINDOW)
                .limit(10)
                .windowSizeSeconds(60)
                .build();
        assertDoesNotThrow(() -> validator.validate("T1", cfg));
    }

    @Test
    void invalidTokenBucketConfig_throws() {
        RateLimitConfig cfg = RateLimitConfig.builder()
                .algorithm(Algorithm.TOKEN_BUCKET)
                .capacity(0)
                .refillRatePerSecond(0.0)
                .build();
        assertThrows(InvalidConfigException.class, () -> validator.validate("T1", cfg));
    }
}