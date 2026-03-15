package com.bhavesh.lohana.rate_limiter.model;

import com.bhavesh.lohana.rate_limiter.domain.Algorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateLimitStatusTest {

    @Test
    void builder_and_getters() {
        RateLimitStatus s = RateLimitStatus.builder()
                .clientId("u1")
                .clientType("t1")
                .algorithm(Algorithm.TOKEN_BUCKET)
                .requestsInWindow(5)
                .currentTokens(2.5)
                .remainingRequests(3)
                .windowResetsInSeconds(10L)
                .build();

        assertEquals("u1", s.getClientId());
        assertEquals(Algorithm.TOKEN_BUCKET, s.getAlgorithm());
        assertEquals(10L, s.getWindowResetsInSeconds());
    }
}

