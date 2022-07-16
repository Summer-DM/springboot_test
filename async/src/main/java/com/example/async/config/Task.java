package com.example.async.config;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Task
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 23:12
 * @Version 1.0
 */
public class Task implements Runnable {

    private final int taskNum;
    CountDownLatch count;


    public Task(int num, CountDownLatch n) {
        this.taskNum = num;
        this.count = n;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "\t" + "忙完工作，下班。");
        } catch (Exception e) {
            System.out.println("task " + taskNum + "执行失败");
        }
        //事情干完了
        count.countDown();
    }
}
