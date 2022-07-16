package com.example.async.service;

import com.example.async.model.User;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName AsyncService
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 9:06
 * @Version 1.0
 */
public interface AsyncService {
    void getDataResult(User user, CountDownLatch count);
}
