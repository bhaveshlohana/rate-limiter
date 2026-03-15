package com.bhavesh.learn.rate_limiter.model;

import com.bhavesh.learn.rate_limiter.domain.Algorithm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RateLimitConfig {
    private String clientType;
    private Algorithm algorithm;
    private Integer limit;
    private Integer windowSizeSeconds;
    private Integer capacity;
    private Double refillRatePerSecond;
}
