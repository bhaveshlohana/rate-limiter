package com.bhavesh.lohana.rate_limiter.model;

import com.bhavesh.lohana.rate_limiter.domain.Algorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateLimitConfigTest {

    @Test
    void builder_and_getters_work() {
        RateLimitConfig cfg = RateLimitConfig.builder()
                .clientType("t1")
                .algorithm(Algorithm.FIXED_WINDOW)
                .limit(10)
                .windowSizeSeconds(60)
                .build();

        assertEquals("t1", cfg.getClientType());
        assertEquals(Algorithm.FIXED_WINDOW, cfg.getAlgorithm());
        assertEquals(10, cfg.getLimit());
    }
}

