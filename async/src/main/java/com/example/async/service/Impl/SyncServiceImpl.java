package com.example.async.service.Impl;

import com.example.async.config.Task;
import com.example.async.service.SyncService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @ClassName SyncServiceImpl
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 15:26
 * @Version 1.0
 */
@Service
public class SyncServiceImpl implements SyncService {

    private static final ExecutorService executorService = new ThreadPoolExecutor(
            //核心线程数
            10,
            //最大连接数
            10,
            //线程最大空闲时间,超过此空闲时间可以被收回
            200L,
            //最大空闲时间的单位
            TimeUnit.MILLISECONDS,
            //用于保存执行任务的队列,可以选择其他不同的队列来做任务管理
            new ArrayBlockingQueue<>(10));

    @Override
    public void closeDoor() throws InterruptedException {
        //创建CountDownLatch,初始容量为10，模拟10名员工
        CountDownLatch countDownLatch = new CountDownLatch(10);
        try {
            for (int i = 1; i <= 10; i++) {
                //启动一个任务
                Task myTask = new Task(i, countDownLatch);
                executorService.execute(myTask);
            }
        } catch (Exception e) {
        e.getStackTrace();
        } finally {
            //当计数器的值变为0,因调用await方法被阻塞的线程会被唤醒,继续执行
            countDownLatch.await();
        }
        System.out.println(Thread.currentThread().getName() + "\t值班人员锁门离开公司");
    }

    /**
     * 多线程并发执行
     * @return
     */
    @Override
    public List<String> execute() throws InterruptedException {
        System.out.println("开始执行多线程...");
        long startTime = System.currentTimeMillis();
        //存放返回结果
        List<String> list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            System.out.println("线程准备中...");
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        list.add(UUID.randomUUID().toString());
                        System.out.println("当前线程name : " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            };
            executorService.execute(runnable);
        }
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
        countDownLatch.await();  // 主线程阻塞，等计数器==0，唤醒主线程往下执行。
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
        System.out.println("submit总共cost 时间：" + (System.currentTimeMillis() - startTime)/1000 + "秒");
        executorService.shutdown();  // 等内部线程执行完，停止线程
        return list;
    }

    /**
     * 多个线程一个个执行
     *
     * @return
     */
    @Override
    public List<String> execute2() throws InterruptedException {
        System.out.println("开始执行多线程...");
        long startTime = System.currentTimeMillis();
        // 存放返回结果
        List<String> list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            System.out.println("线程准备中...");
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString());
                    System.out.println("当前线程name : " + Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            };
            executorService.execute(runnable);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
        countDownLatch.await();  // 主线程阻塞，等计数器==0，唤醒主线程往下执行。
        System.out.println("countDownLatch.getCount(): " + countDownLatch.getCount());
        System.out.println("submit总共cost 时间：" + (System.currentTimeMillis()-startTime)/1000 + "秒");
        executorService.shutdown();  // 等内部线程执行完，停止线程
        return list;
    }
}
