package com.example.async.service;

import java.util.List;

/**
 * @ClassName SyncService
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 15:25
 * @Version 1.0
 */
public interface SyncService {
    /**
     * 多线程测试
     * @throws InterruptedException
     */
    void closeDoor() throws InterruptedException;

    /**
     * 多线程并发执行
     */
    List<String> execute() throws InterruptedException;

    /**
     * 多个线程一个个执行
     * @return
     */
    List<String> execute2() throws InterruptedException;
}
