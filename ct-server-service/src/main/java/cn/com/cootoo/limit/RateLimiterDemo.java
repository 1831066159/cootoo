package cn.com.cootoo.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author system
 * @create 2019/8/9
 **/
public class RateLimiterDemo {


    public static void main(String[] args) {
        testNoRateLimiter();
        testWithRateLimiter();
    }

    public static void testNoRateLimiter() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(System.currentTimeMillis() + "-call execute.." + i);

        }
        Long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    public static void testWithRateLimiter() {
        Long start = System.currentTimeMillis();
        // 每秒不超过1个任务被提交
        RateLimiter limiter = RateLimiter.create(1.0);
        for (int i = 0; i < 10; i++) {
            // 请求RateLimiter, 超过permits会被阻塞
            limiter.acquire();
            System.out.println(System.currentTimeMillis() + "-call execute.." + i);

        }
        Long end = System.currentTimeMillis();

        System.out.println(end - start);

    }


}
