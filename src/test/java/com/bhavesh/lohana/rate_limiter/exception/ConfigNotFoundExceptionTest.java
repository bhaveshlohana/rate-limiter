package com.bhavesh.lohana.rate_limiter.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigNotFoundExceptionTest {

    @Test
    void message_isStored() {
        ConfigNotFoundException e = new ConfigNotFoundException("nope");
        assertEquals("nope", e.getMessage());
    }
}

