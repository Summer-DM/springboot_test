package com.example.design_patterns.factory;

/**
 * @ClassName LzNoodles
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 8:05
 * @Version 1.0
 */
public class LzNoodles implements INoodles{
    /**
     * 描述每种面条啥样的
     */
    @Override
    public void desc() {
        System.out.println("兰州拉面 上海的好贵 家里才5 6块钱一碗");
    }
}
