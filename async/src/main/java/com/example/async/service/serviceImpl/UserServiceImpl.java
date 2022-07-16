package com.example.async.service.serviceImpl;

import com.example.async.model.User;
import com.example.async.service.AsyncService;
import com.example.async.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 9:30
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AsyncService asyncService;

    @Override
    public Map<String, List<User>> getUserInfo() {
        Map<String, List<User>> map = new HashMap<>(16);
        List<User> userList = User.getUserList();
        CountDownLatch count = new CountDownLatch(userList.size());
        try {
            for (User user : userList) {
                asyncService.getDataResult(user, count);
            }
            count.await();
            map.put("data", userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
