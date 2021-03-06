package com.example.design_patterns.factory;

/**
 * @ClassName SimpleNoodlesFactory
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/17 8:07
 * @Version 1.0
 */
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面
    public static final int TYPE_GK = 3;//干扣面
    public static INoodles createNoodles(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_GK:
            default:
                return new ReGanNoodles();
        }
    }
}
