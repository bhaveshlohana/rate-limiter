package com.bhavesh.learn.rate_limiter.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateLimitRequestTest {

    @Test
    void builder_and_getters() {
        RateLimitRequest r = RateLimitRequest.builder().clientId("u1").clientType("t1").build();
        assertEquals("u1", r.getClientId());
        assertEquals("t1", r.getClientType());
    }
}

