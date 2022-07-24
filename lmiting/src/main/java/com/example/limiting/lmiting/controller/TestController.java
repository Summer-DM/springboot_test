package com.example.limiting.lmiting.controller;

import com.example.limiting.lmiting.model.LimitType;
import com.example.limiting.lmiting.model.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/24 17:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/rateLimiter")
public class TestController {

    /**
     * 每一个ip只能在60秒内，访问3次
     * @return
     */
    @GetMapping("/hello")
    @RateLimiter(time = 60, count = 3, limitType = LimitType.IP)
    public String hello() {
        return "hello>>>" + new Date();
    }
}
