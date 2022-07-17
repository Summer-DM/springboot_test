package com.example.design_patterns.decorator;

/**
 * @ClassName SunService
 * @Description TODO  扩展类
 * @Author Summer_DM
 * @Date 2022/7/17 7:35
 * @Version 1.0
 */
public class SunService extends WomanService{
    @Override
    public void eat() {
        super.eat();
        reEat();
        System.out.println("SunService类");
    }
    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}

