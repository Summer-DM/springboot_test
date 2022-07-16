package com.example.async.service.serviceImpl;

import com.example.async.model.User;
import com.example.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName AsyncServiceImpl
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 9:07
 * @Version 1.0
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncServiceImpl.class);

    /**
     * @param user
     * @param count
     * @Async注解表示异步，后面的参数对应于线程池配置类ExecutorConfig中的方法名asyncServiceExecutor()， 如果不写后面的参数，直接使用@Async注解，则是使用默认的线程池
     * Future<String>为异步返回的结果。可以通过get()方法获取结果。
     */
    @Override
    @Async("taskExecutor")
    public void getDataResult(User user, CountDownLatch count) {
        log.info("开始异步处理,线程名称：" + Thread.currentThread().getName());
        try {
            user.setUserName("赵四");
            user.setId(count.getCount()+Thread.currentThread().getId());
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            count.countDown();
        }
        log.info("结束异步处理,线程名称：" + Thread.currentThread().getName());
    }
}
