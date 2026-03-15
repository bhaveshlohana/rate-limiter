import http from 'k6/http';
import { check, sleep } from 'k6';
import { Counter, Rate } from 'k6/metrics';

// custom metrics
const allowedRequests = new Counter('allowed_requests');
const rejectedRequests = new Counter('rejected_requests');
const rejectionRate = new Rate('rejection_rate');

export const options = {
  scenarios: {
    fixed_window: {
      executor: 'constant-vus',
      vus: 10,              // 10 concurrent users
      duration: '30s',
      env: { CLIENT_TYPE: 'DEFAULT' }
    },
    sliding_window: {
        executor: 'constant-vus',
        vus: 10,
        duration: '30s',
        startTime: '35s',     // starts after fixed window test
        env: { CLIENT_TYPE: 'NORMAL' }
    },
    token_bucket: {
      executor: 'constant-vus',
      vus: 10,
      duration: '30s',
      startTime: '70s',     // starts after fixed window test
      env: { CLIENT_TYPE: 'PREMIUM' }
    }
  }
};

export default function() {
  const payload = JSON.stringify({
    clientId: `user-${__VU}`,   // __VU is the virtual user number
    clientType: __ENV.CLIENT_TYPE
  });

  const params = {
    headers: { 'Content-Type': 'application/json' }
  };

  const res = http.post(
    'http://localhost:8080/api/rate-limiter/check',
    payload,
    params
  );

  const allowed = res.status === 200;
  const rejected = res.status === 429;

  check(res, {
    'status is 200 or 429': (r) => r.status === 200 || r.status === 429,
    'response time < 200ms': (r) => r.timings.duration < 200
  });

  if (allowed) allowedRequests.add(1);
  if (rejected) {
    rejectedRequests.add(1);
    rejectionRate.add(1);
  } else {
    rejectionRate.add(0);
  }

  sleep(0.1);   // 100ms between requests per user
}