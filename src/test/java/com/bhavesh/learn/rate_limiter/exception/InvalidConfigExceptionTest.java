package com.bhavesh.learn.rate_limiter.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidConfigExceptionTest {

    @Test
    void message_isStored() {
        InvalidConfigException e = new InvalidConfigException("msg");
        assertEquals("msg", e.getMessage());
    }
}

