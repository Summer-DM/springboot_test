package com.example.design_patterns.factory;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 8:07
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 简单工厂模式
         */
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
        noodles.desc();
    }
}
