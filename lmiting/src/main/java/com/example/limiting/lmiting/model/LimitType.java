package com.example.limiting.lmiting.model;

/**
 * @ClassName LimitType
 * @Description TODO 接下来我们创建一个限流注解，我们将限流分为两种情况：
 * TODO 针对当前接口的全局性限流，例如该接口可以在 1 分钟内访问 100 次。
 * TODO 针对某一个 IP 地址的限流，例如某个 IP 地址可以在 1 分钟内访问 100 次。
 * @Author Summer_DM
 * @Date 2022/7/24 17:24
 * @Version 1.0
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP
}
