package cn.com.cootoo;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author system
 * @create 2019/5/17
 **/
public class TestRateLimiter {

    @Test
    public void testRateLimiter() {
        // 每秒最多创建5个,并且以固定速率进行放置，达到平滑输出的效果。
        RateLimiter limiter = RateLimiter.create(5);
        while (true) {

            System.out.println(" ----- " + limiter.acquire());
        }
    }


    @Test
    public void testRateLimiter2() {
        // RateLimiter使用令牌桶算法，会进行令牌的累积，如果获取令牌的频率比较低，则不会导致等待，直接获取令牌
        RateLimiter limiter = RateLimiter.create(2);
        while (true) {

            System.out.println(" ----- " + limiter.acquire(1));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get 1 tokens: " + limiter.acquire(1) + "s");
            System.out.println("get 1 tokens: " + limiter.acquire(1) + "s");
            System.out.println("get 1 tokens: " + limiter.acquire(1) + "s");
        }
    }

    @Test
    public void testSmoothwarmingUp() {
        // RateLimiter的SmoothWarmingUp是带有预热期的平滑限流，它启动后会有一段预热期，逐步将分发频率提升到配置的速率。
        RateLimiter r = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 1 tokens: 0.0s
             * get 1 tokens: 1.329289s
             * get 1 tokens: 0.994375s
             * get 1 tokens: 0.662888s  上边三次获取的时间相加正好为3秒
             * end
             * get 1 tokens: 0.49764s  正常速率0.5秒一个令牌
             * get 1 tokens: 0.497828s
             * get 1 tokens: 0.49449s
             * get 1 tokens: 0.497522s
             */
        }
    }
}
