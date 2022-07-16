package com.example.async.service;

import com.example.async.model.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 9:29
 * @Version 1.0
 */
public interface UserService {
    Map<String, List<User>> getUserInfo();
}
