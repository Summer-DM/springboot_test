package com.example.async.controller;

import com.example.async.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SyncController
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 23:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/sync")
public class SyncController {

    @Autowired
    private SyncService syncService;
    /**
     * 测试 多线程并发
     */
    @GetMapping("/user/sync")
    public void getSyncResult() throws InterruptedException {
        syncService.closeDoor();
    }

    /**
     * 测试 多线程并发2;     线程一起执行,即所有线程并行执行
     */
    @GetMapping("/user/sync2")
    public void getSyncResult2() throws InterruptedException {
        List<String> res = new ArrayList<>();
        res =  syncService.execute();
        System.out.println(res);
    }
    /**
     * 测试 多个线程一个个执行;
     */
    @GetMapping("/user/sync3")
    public void getSyncResult3() throws InterruptedException {
        List<String> res = new ArrayList<>();
        res =  syncService.execute2();
        System.out.println(res);
    }
}
