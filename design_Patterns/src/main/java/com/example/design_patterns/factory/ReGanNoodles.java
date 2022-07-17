package com.example.design_patterns.factory;

/**
 * @ClassName ReGanNoodles
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 8:06
 * @Version 1.0
 */
public class ReGanNoodles implements INoodles{
    /**
     * 描述每种面条啥样的
     */
    @Override
    public void desc() {
        System.out.println("还是家里的热干面好吃 6块一碗");
    }
}
