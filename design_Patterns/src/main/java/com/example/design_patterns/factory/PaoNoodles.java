package com.example.design_patterns.factory;

/**
 * @ClassName PaoNoodles
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 8:05
 * @Version 1.0
 */
public class PaoNoodles implements INoodles{
    /**
     * 描述每种面条啥样的
     */
    @Override
    public void desc() {
        System.out.println("泡面好吃 可不要贪杯");
    }
}
