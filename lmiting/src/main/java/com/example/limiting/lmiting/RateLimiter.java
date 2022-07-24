package com.example.limiting.lmiting;

import java.lang.annotation.*;

/**
 * @ClassName RateLimiter
 * @Description TODO  限流注解
 * @Author Summer_DM
 * @Date 2022/7/24 17:25
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    /**
     * 限流key。这个仅仅是一个前缀，将来完整的 key 是这个前缀再加上接口方法的完整路径，共同组成限流 key，这个 key 将被存入到 Redis 中。
     */
    String key() default "rate_limit:";

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    LimitType limitType() default LimitType.DEFAULT;
}