package com.example.async.controller;

import com.example.async.model.User;
import com.example.async.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AsyncController
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 9:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/async")
public class AsyncController {
    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);
    @Autowired
    private UserService userService;


    /**
     * 调用异步服务，获取异步结果。测试异步线程执行
     */
    @GetMapping("/user/query")
    public List<User> getAsyncResult() {
        Map<String, List<User>> result = userService.getUserInfo();
        log.info("异步处理结果为：{}", result.get("data"));
        return result.get("data");
    }
}
