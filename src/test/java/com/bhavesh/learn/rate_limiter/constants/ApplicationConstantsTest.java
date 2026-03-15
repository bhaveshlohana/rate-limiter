package com.bhavesh.learn.rate_limiter.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationConstantsTest {

    @Test
    void constants_expectedValues() {
        assertEquals("ratelimit:", ApplicationConstants.RATELIMIT);
        assertEquals(":", ApplicationConstants.SEPARATOR);
        assertEquals("DEFAULT", ApplicationConstants.DEFAULT);
    }
}

