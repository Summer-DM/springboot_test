package com.example.design_patterns.decorator;

/**
 * @ClassName ManService
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 7:29
 * @Version 1.0
 */
public class ManService implements Decorator{
    @Override
    public void eat() {
        System.out.println("男人在吃饭！");
    }
}
