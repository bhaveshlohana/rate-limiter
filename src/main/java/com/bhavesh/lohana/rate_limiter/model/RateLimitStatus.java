package com.bhavesh.lohana.rate_limiter.model;

import com.bhavesh.lohana.rate_limiter.domain.Algorithm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitStatus {
    private String clientId;
    private String clientType;
    private Algorithm algorithm;
    private Integer requestsInWindow;    // Fixed/Sliding Window
    private Double currentTokens;        // Token Bucket
    private Integer remainingRequests;
    private Long windowResetsInSeconds;  // TTL of the key
}
